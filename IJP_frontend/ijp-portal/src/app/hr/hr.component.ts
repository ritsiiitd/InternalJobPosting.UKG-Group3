import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
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
      
      <div class="mb-4 flex justify-between items-center">
        <button 
          (click)="navigateToNewJobForm()"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Add New Job
        </button>
        <button 
          (click)="toggleShowClosedJobs()"
          class="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded"
        >
          {{ showClosedJobs ? 'Show Active Jobs' : 'Show Closed Jobs' }}
        </button>
      </div>
      <div>
        <app-job-row 
          *ngFor="let job of filteredJobs" 
          [job]="job"
          (closeJob)="closeJob($event)"
          (deleteJob)="deleteJob($event)"
        ></app-job-row>
      </div>
    </div>
  `,
  styleUrls: ['./hr.component.css']
})
export class HrComponent implements OnInit, OnDestroy {
  jobs: Job[] = [];
  filteredJobs: Job[] = [];
  showClosedJobs = false;
  private jobSubscription: Subscription | undefined;

  constructor(private router: Router, private jobService: JobService) {}

  ngOnInit() {
    this.jobSubscription = this.jobService.getJobs().subscribe(jobs => {
      console.log('Received updated jobs:', jobs);
      this.jobs = jobs;
      this.filterJobs();
    });
  }

  ngOnDestroy() {
    if (this.jobSubscription) {
      this.jobSubscription.unsubscribe();
    }
  }

  navigateToNewJobForm() {
    this.router.navigate(['/hr/new-job']);
  }

  toggleShowClosedJobs() {
    this.showClosedJobs = !this.showClosedJobs;
    this.filterJobs();
  }

  filterJobs() {
    this.filteredJobs = this.jobs.filter(job => 
      this.showClosedJobs ? !job.isActive : job.isActive
    );
  }

  closeJob(jobId: number) {
    this.jobService.closeJob(jobId).subscribe(
      success => {
        if (success) {
          console.log('Job closed successfully');
        } else {
          console.error('Failed to close job');
        }
        // The job list will be updated automatically via the BehaviorSubject
      },
      error => console.error('Error closing job:', error)
    );
  }

  deleteJob(jobId: number) {
    this.jobService.deleteJob(jobId).subscribe(
      () => {
        console.log('Job deleted successfully');
        // The job list will be updated automatically via the BehaviorSubject
      },
      error => console.error('Error deleting job:', error)
    );
  }
}