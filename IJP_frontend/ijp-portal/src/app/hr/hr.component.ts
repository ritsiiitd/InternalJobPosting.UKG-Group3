import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { JobRowComponent } from '../job-row/job-row.component';
import { Job } from '../models/job.model';
import { JobService } from '../services/job.service';

@Component({
  selector: 'app-hr',
  standalone: true,
  imports: [CommonModule, JobRowComponent],
  template: `
    <div class="container mx-auto px-4">
      <h2 class="text-2xl font-bold mb-4">HR Dashboard</h2>
      <div class="mb-4">
        <button 
          (click)="navigateToNewJobForm()"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Add New Job
        </button>
      </div>
      <div>
        <app-job-row 
          *ngFor="let job of jobs" 
          [job]="job"
        ></app-job-row>
      </div>
    </div>
  `,
  styleUrls: ['./hr.component.css']
})
export class HrComponent implements OnInit {
  jobs: Job[] = [];

  constructor(private router: Router, private jobService: JobService) {}

  ngOnInit() {
    this.jobService.getJobs().subscribe(jobs => {
      this.jobs = jobs;
    });
  }

  navigateToNewJobForm() {
    this.router.navigate(['/hr/new-job']);
  }
}