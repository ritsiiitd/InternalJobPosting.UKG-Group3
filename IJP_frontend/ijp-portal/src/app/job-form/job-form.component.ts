// job-form.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Job,LanguageGroup,CodingLanguage } from '../models/job.model';
import { JobService, Location } from '../services/job.service';
@Component({
  selector: 'app-job-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container mx-auto px-4 py-8">
      <h2 class="text-2xl font-bold mb-4">Create New Job</h2>
      <form (ngSubmit)="onSubmit()" #jobForm="ngForm" class="space-y-4">
        <div>
          <label for="designation" class="block text-sm font-medium text-gray-700">Designation</label>
          <input type="text" id="designation" name="designation" [(ngModel)]="job.designation" required
                 class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
        </div>
        <div>
          <label for="description" class="block text-sm font-medium text-gray-700">Description</label>
          <textarea id="description" name="description" [(ngModel)]="job.description" required
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50"></textarea>
        </div>
        <div>
          <label for="minExp" class="block text-sm font-medium text-gray-700">Minimum Experience (years)</label>
          <input type="number" id="minExp" name="minExp" [(ngModel)]="job.minExp" required
                 class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
        </div>
        <div>
          <label for="minSal" class="block text-sm font-medium text-gray-700">Minimum Salary</label>
          <input type="number" id="minSal" name="minSal" [(ngModel)]="job.minSal" required
                 class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
        </div>
        <div>
          <label for="maxSal" class="block text-sm font-medium text-gray-700">Maximum Salary</label>
          <input type="number" id="maxSal" name="maxSal" [(ngModel)]="job.maxSal" required
                 class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
        </div>
        <div>
          <label for="deadline" class="block text-sm font-medium text-gray-700">Deadline</label>
          <input type="date" id="deadline" name="deadline" [(ngModel)]="job.deadline" required
                 class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50">
        </div>

        <div>
        <label>Locations</label>
        <div *ngFor="let location of locations">
          <input type="checkbox" 
                 [value]="location.id" 
                 >
          {{ location.name }}
        </div>
      </div>

      <div>
        <label>Coding Languages</label>
        <div *ngFor="let langGroup of languageGroups">
          <input type="checkbox" 
                 [id]="'lang-' + langGroup.langName"
                 >
          {{ langGroup.langName }}
          <div *ngIf="isLanguageChecked(langGroup)">
            <div *ngFor="let skill of langGroup.skills">
              <input type="radio" 
                     [name]="'skill-' + langGroup.langName"
                     [value]="skill.id" 
                     >
              {{ skill.skill }}
            </div>
          </div>
        </div>
      </div>

        <div>
          <button type="submit" [disabled]="!jobForm.form.valid"
                  class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
            Create Job
          </button>
        </div>
      </form>
    </div>
  `,
  styleUrls: ['./job-form.component.css']
})
export class JobFormComponent implements OnInit {
    job: Omit<Job, 'jobPosId'> = {
      description: '',
      minExp: 0,
      minSal: 0,
      maxSal: 0,
      isActive: true,
      designation: '',
      createdBy: 1, // You might want to get this from a logged-in user's info
      deadline: new Date().toISOString().split('T')[0],
      locations: [],
      codingLanguages: []
    };
  
    locations: Location[] = [];
    languageGroups: LanguageGroup[] = [];
    checkedLanguages: Set<string> = new Set();
  
    constructor(private router: Router, private jobService: JobService) {}
  
    ngOnInit() {
      this.jobService.getLocations().subscribe(locations => this.locations = locations);
      this.jobService.getCodingLanguages().subscribe(languages => {
        this.groupLanguages(languages);
      });
    }
  
    groupLanguages(languages: CodingLanguage[]) {
      const groups: { [key: string]: CodingLanguage[] } = {};
      languages.forEach(lang => {
        if (!groups[lang.langName]) {
          groups[lang.langName] = [];
        }
        groups[lang.langName].push(lang);
      });
      this.languageGroups = Object.keys(groups).map(langName => ({
        langName,
        skills: groups[langName]
      }));
    }
  
    // onLocationChange(locationId: number, event: any) {
    //   if (event.target.checked) {
    //     this.job.locations.push(locationId);
    //   } else {
    //     this.job.locations = this.job.locations.filter(id => id !== locationId);
    //   }
    // }
  
    onLanguageChecked(langGroup: LanguageGroup, event: any) {
      if (event.target.checked) {
        this.checkedLanguages.add(langGroup.langName);
      } else {
        this.checkedLanguages.delete(langGroup.langName);
        this.job.codingLanguages = this.job.codingLanguages.filter(
          id => !langGroup.skills.some(skill => skill.id === id)
        );
      }
    }
  
    isLanguageChecked(langGroup: LanguageGroup): boolean {
      return this.checkedLanguages.has(langGroup.langName);
    }
  
    onSkillSelected(languageId: number) {
      this.job.codingLanguages = this.job.codingLanguages.filter(
        id => !this.languageGroups.some(group => 
          group.skills.some(skill => skill.id === id && skill.id !== languageId)
        )
      );
      if (!this.job.codingLanguages.includes(languageId)) {
        this.job.codingLanguages.push(languageId);
      }
    }
  
    onSubmit() {
      this.jobService.addJob(this.job).subscribe(
        response => {
          console.log('Job created successfully', response);
          this.router.navigate(['/hr']);
        },
        error => {
          console.error('Error creating job', error);
        }
      );
    }
  }