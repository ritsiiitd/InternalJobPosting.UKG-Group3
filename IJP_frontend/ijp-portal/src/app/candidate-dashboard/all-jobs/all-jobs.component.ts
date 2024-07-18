import { Component, OnInit } from '@angular/core';
// import { JobPosting } from '../../models/JobPosting.model';
import { JobPostingService } from '../../services/JobPosting.service';
import { ApplicationService } from '../../services/application.service';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import {Job} from '../../models/JobPosting.model';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';

// import { MOCK_JOBS } from '../../mock-jobs';


@Component({
  selector: 'all-jobs',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterOutlet],
  templateUrl: './all-jobs.component.html',
  styleUrl: './all-jobs.component.css'
})

export class AllJobsComponent implements OnInit {
  allJobs: Job[] = [];
  appliedJobs: Set<number> = new Set<number>();

  constructor(
    private jobPostingService: JobPostingService,
    private applicationService: ApplicationService
  ) {}

  ngOnInit(): void {
    this.loadAllJobs();
  }

  loadAllJobs(): void {
    this.jobPostingService.getAllJobs().subscribe({
      next: (jobs: Job[]) => {
        this.allJobs = jobs;
      },
      error: (error: any) => {
        console.error('Error loading all jobs:', error);
      }
    });
  }

  applyForJob(jobPosId: number): void {
    const application = {
      employee_id: 3, // Replace with the actual employee ID
      // app_id: 1, 
      job_pos_id: jobPosId,
      verified_by_manager: false
      // status: 'pending'
    };

    this.jobPostingService.createApplication(application).subscribe({
      next: () => {
        console.log('Application created successfully');
        this.appliedJobs.add(jobPosId);
        
        Swal.fire({
          title: `You have successfully applied`,
          text: "Thanks for applying",
          icon: "success",
          showConfirmButton: true,
          confirmButtonColor: '#800000'
        });
      },
      error: (error: any) => {
        console.error('Error creating application:', error);

        // Show error alert
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Something went wrong!",
          showConfirmButton: true,
          confirmButtonColor: '#800000'
        });
      }
    });
  }
}
  

  // setTimeout(() => {
  //   this.allJobs = MOCK_JOBS;
  // }, 1000); // 1 second delay to simulate network request

