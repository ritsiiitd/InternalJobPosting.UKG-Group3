// job-form.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Job } from '../models/job.model';
import { JobService, Location, CodingLanguage } from '../services/job.service';
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
            <label class="block text-sm font-medium text-gray-700">Locations</label>
            <div class="mt-2 space-y-2">
              <div *ngFor="let location of locations" class="flex items-center">
                <input type="checkbox" 
                       [id]="'location-' + location.id" 
                       [value]="location.id" 
                       (change)="onLocationChange(location.id, $event)"
                       class="mr-2">
                <label [for]="'location-' + location.id">{{ location.name }}</label>
              </div>
            </div>
          </div>
          
          <div>
            <label class="block text-sm font-medium text-gray-700">Coding Languages</label>
            <div class="mt-2 space-y-2">
              <div *ngFor="let lang of codingLanguages" class="flex items-center">
                <input type="checkbox" 
                       [id]="'lang-' + lang.id" 
                       [value]="lang.id" 
                       (change)="onCodingLanguageChange(lang.id, $event)"
                       class="mr-2">
                <label [for]="'lang-' + lang.id">{{ lang.name }}</label>
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
    codingLanguages: CodingLanguage[] = [];
  
    constructor(private router: Router, private jobService: JobService) {}
  
    ngOnInit() {
      this.jobService.getLocations().subscribe(locations => this.locations = locations);
      this.jobService.getCodingLanguages().subscribe(languages => this.codingLanguages = languages);
    }
  
    onLocationChange(locationId: number, event: any) {
      if (event.target.checked) {
        this.job.locations.push(locationId);
      } else {
        this.job.locations = this.job.locations.filter(id => id !== locationId);
      }
    }
  
    onCodingLanguageChange(langId: number, event: any) {
      if (event.target.checked) {
        this.job.codingLanguages.push(langId);
      } else {
        this.job.codingLanguages = this.job.codingLanguages.filter(id => id !== langId);
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
          // Handle error (e.g., show error message to user)
        }
      );
    }
  }