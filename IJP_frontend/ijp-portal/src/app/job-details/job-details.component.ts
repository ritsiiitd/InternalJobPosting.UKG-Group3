// job-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { JobService } from '../services/job.service';
import { Job, CodingLanguage } from '../models/job.model';
import { Location } from '../services/job.service';
import { forkJoin } from 'rxjs';
import { Application } from '../models/JobPosting.model';
import { ApplicationDto } from '../services/application.service';

@Component({
  selector: 'app-job-details',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="container mx-auto px-4 py-8" *ngIf="job">
      <h2 class="text-2xl font-bold mb-4">{{ job.designation }}</h2>
      <button (click)="viewApplications()" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          View Applications - ({{ applications.length }})
        </button>
      <div class="bg-white shadow overflow-hidden sm:rounded-lg">
        <div class="px-4 py-5 sm:px-6">
          <h3 class="text-lg leading-6 font-medium text-gray-900">Job Details</h3>
        </div>
        <div class="border-t border-gray-200">
          <dl>
            <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Description</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">{{ job.description }}</dd>
            </div>
            <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Minimum Experience</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">{{ job.minExp }} years</dd>
            </div>
            <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Salary Range</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">{{ job.minSal }} - {{ job.maxSal }}</dd>
            </div>
            <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Status</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">{{ job.isActive ? 'Active' : 'Inactive' }}</dd>
            </div>
            <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Deadline</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">{{ job.deadline | date }}</dd>
            </div>

            <div class="bg-gray-50 px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Locations</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                <span *ngFor="let location of jobLocations; let last = last">
                  {{ location.name }}{{ !last ? ', ' : '' }}
                </span>
              </dd>
            </div>
            <div class="bg-white px-4 py-5 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-6">
              <dt class="text-sm font-medium text-gray-500">Coding Languages</dt>
              <dd class="mt-1 text-sm text-gray-900 sm:mt-0 sm:col-span-2">
                <span *ngFor="let lang of jobCodingLanguages; let last = last">
                  {{ lang.langName }} ({{ lang.skill }}){{ !last ? ', ' : '' }}
                </span>
              </dd>
            </div>
          </dl>
        </div>
      </div>
    </div>
  `,
  styleUrls: ['./job-details.component.css']
})

export class JobDetailsComponent implements OnInit {
  job: Job | null = null;
  allLocations: Location[] = [];
  allCodingLanguages: CodingLanguage[] = [];
  jobLocations: Location[] = [];
  jobCodingLanguages: CodingLanguage[] = [];
  applications: ApplicationDto[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private jobService: JobService
  ) {}

  viewApplications() {
    if (this.job) {
      this.router.navigate(['/job', this.job.jobPosId, 'applications']);
    }
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const jobId = params['id'];
    
      if (jobId) {
        forkJoin({
          job: this.jobService.getJobById(Number(jobId)),
          locations: this.jobService.getLocations(),
          applications: this.jobService.getApplicationsByJobId(jobId),
          languages: this.jobService.getCodingLanguages()
        }).subscribe(
          result => {
            this.job = result.job;
            this.allLocations = result.locations;
            this.applications = result.applications;
            this.allCodingLanguages = result.languages;
            this.filterJobDetails();
          },
          error => console.error('Error fetching job details:', error)
        );
      }
    });
  }

  filterJobDetails() {
    if (this.job) {
      this.allLocations.map(location =>   
        {
          console.log("FOR me ", this.job?.locations);
          console.log("FOR me ", location);
          if(this.job?.locations.includes(location.locationId)){
            this.jobLocations.push(location);
            console.log("Adding me ", this.jobLocations);
            
          }
        }
      );
      this.allCodingLanguages.map(codingLang =>   
        {
          console.log("FOR me ", this.job?.codingLanguages);
          console.log("FOR me ", codingLang);
          if(this.job?.codingLanguages.includes(codingLang.languageId)){
            this.jobCodingLanguages.push(codingLang);
          }
        }
      );
      this.jobCodingLanguages = this.allCodingLanguages.filter(lang => 
        this.job!.codingLanguages.includes(lang.languageId)
      );
    }
  }
}