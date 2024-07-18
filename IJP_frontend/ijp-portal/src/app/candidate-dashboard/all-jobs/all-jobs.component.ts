// // import { Component, OnInit } from '@angular/core';
// // // import { JobPosting } from '../../models/JobPosting.model';
// // import { JobPostingService } from '../../services/JobPosting.service';
// // import { ApplicationService } from '../../services/application.service';
// // import { CommonModule } from '@angular/common';
// // import { RouterLink, RouterOutlet } from '@angular/router';
// // import {Job} from '../../models/JobPosting.model';
// // import { HttpClient } from '@angular/common/http';
// // import Swal from 'sweetalert2';

// // // import { MOCK_JOBS } from '../../mock-jobs';


// // @Component({
// //   selector: 'all-jobs',
// //   standalone: true,
// //   imports: [CommonModule, RouterLink, RouterOutlet],
// //   templateUrl: './all-jobs.component.html',
// //   styleUrl: './all-jobs.component.css'
// // })

// // export class AllJobsComponent implements OnInit {
// //   allJobs: Job[] = [];
// //   appliedJobs: Set<number> = new Set<number>();

// //   constructor(
// //     private jobPostingService: JobPostingService,
// //     private applicationService: ApplicationService
// //   ) {}

// //   ngOnInit(): void {
// //     this.loadAllJobs();
// //   }

// //   loadAllJobs(): void {
// //     this.jobPostingService.getAllJobs().subscribe({
// //       next: (jobs: Job[]) => {
// //         this.allJobs = jobs;
// //       },
// //       error: (error: any) => {
// //         console.error('Error loading all jobs:', error);
// //       }
// //     });
// //   }
  
// //   applyForJob(jobPosId: number): void {
// //     const application = {
// //       employee_id: 3, // Replace with the actual employee ID
// //       // app_id: 1, 
// //       job_pos_id: jobPosId,
// //       verified_by_manager: false
// //       // status: 'pending'
// //     };

// //     this.jobPostingService.createApplication(application).subscribe({
// //       next: () => {
// //         console.log('Application created successfully');
// //         this.appliedJobs.add(jobPosId);
        
// //         Swal.fire({
// //           title: `You have successfully applied`,
// //           text: "Thanks for applying",
// //           icon: "success",
// //           showConfirmButton: true,
// //           confirmButtonColor: '#800000'
// //         });
// //       },
// //       error: (error: any) => {
// //         console.error('Error creating application:', error);

// //         // Show error alert
// //         Swal.fire({
// //           icon: "error",
// //           title: "Oops...",
// //           text: "Something went wrong!",
// //           showConfirmButton: true,
// //           confirmButtonColor: '#800000'
// //         });
// //       }
// //     });


// //   }
// // }
  

// //   // setTimeout(() => {
// //   //   this.allJobs = MOCK_JOBS;
// //   // }, 1000); // 1 second delay to simulate network request

// import { Component, OnInit } from '@angular/core';
// import { JobPostingService } from '../../services/JobPosting.service';
// import { ApplicationService } from '../../services/application.service';
// import { CommonModule } from '@angular/common';
// import { RouterLink, RouterOutlet, ActivatedRoute } from '@angular/router';
// import { Job } from '../../models/JobPosting.model';
// import Swal from 'sweetalert2';
// import { AuthService } from '../../auth.service';

// @Component({
//   selector: 'all-jobs',
//   standalone: true,
//   imports: [CommonModule, RouterLink, RouterOutlet],
//   templateUrl: './all-jobs.component.html',
//   styleUrl: './all-jobs.component.css'
// })
// export class AllJobsComponent implements OnInit {
//   allJobs: Job[] = [];
//   appliedJobs: Set<number> = new Set<number>();
//   employeeId: number | null = null;

//   constructor(
//     private jobPostingService: JobPostingService,
//     private applicationService: ApplicationService,
//     private route: ActivatedRoute
//   ) {}

//   ngOnInit(): void {
//     const employeeId = this.authService.getCurrentEmployeeId();
//     if (this.employeeId) {
//       this.loadAllJobs();
//       this.loadAppliedJobsFromStorage();
//     } else {
//       console.error('Employee ID not provided in URL');
//     }
//   }

//   loadAllJobs(): void {
//     this.jobPostingService.getAllJobs().subscribe({
//       next: (jobs: Job[]) => {
//         this.allJobs = jobs;
//       },
//       error: (error: any) => {
//         console.error('Error loading all jobs:', error);
//       }
//     });
//   }

//   loadAppliedJobsFromStorage(): void {
//     const storedAppliedJobs = localStorage.getItem(`appliedJobs_${this.employeeId}`);
//     if (storedAppliedJobs) {
//       this.appliedJobs = new Set(JSON.parse(storedAppliedJobs));
//     }
//   }

//   saveAppliedJobsToStorage(): void {
//     localStorage.setItem(`appliedJobs_${this.employeeId}`, JSON.stringify([...this.appliedJobs]));
//   }

//   isJobApplied(jobPosId: number): boolean {
//     return this.appliedJobs.has(jobPosId);
//   }

//   applyForJob(jobPosId: number): void {
//     if (!this.employeeId) {
//       console.error('Employee ID not available');
//       Swal.fire({
//         icon: "error",
//         title: "Oops...",
//         text: "Employee ID not available. Please try again later.",
//         showConfirmButton: true,
//         confirmButtonColor: '#800000'
//       });
//       return;
//     }

//     const application = {
//       employee_id: this.employeeId,
//       job_pos_id: jobPosId,
//       verified_by_manager: false
//     };

//     this.jobPostingService.createApplication(application).subscribe({
//       next: () => {
//         console.log('Application created successfully');
//         this.appliedJobs.add(jobPosId);
//         this.saveAppliedJobsToStorage();
        
//         Swal.fire({
//           title: `You have successfully applied`,
//           text: "Thanks for applying",
//           icon: "success",
//           showConfirmButton: true,
//           confirmButtonColor: '#800000'
//         });
//       },
//       error: (error: any) => {
//         console.error('Error creating application:', error);

//         Swal.fire({
//           icon: "error",
//           title: "Oops...",
//           text: "Something went wrong while applying for the job!",
//           showConfirmButton: true,
//           confirmButtonColor: '#800000'
//         });
//       }
//     });
//   }
// }

import { Component, OnInit } from '@angular/core';
import { JobPostingService } from '../../services/JobPosting.service';
import { ApplicationService } from '../../services/application.service';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { Job } from '../../models/JobPosting.model';
import Swal from 'sweetalert2';
import { AuthService } from '../../services/auth.service';

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
  employeeId: number | null = null;

  constructor(
    private jobPostingService: JobPostingService,
    private applicationService: ApplicationService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.employeeId = this.authService.getCurrentEmployeeId();
    if (this.employeeId !== null) {
      this.loadAllJobs();
      this.loadAppliedJobsFromStorage();
    } else {
      console.error('No employee ID available');
      // Handle the case when no employee ID is available
      // You might want to show an error message or redirect
    }
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

  loadAppliedJobsFromStorage(): void {
    const storedAppliedJobs = localStorage.getItem(`appliedJobs_${this.employeeId}`);
    if (storedAppliedJobs) {
      this.appliedJobs = new Set(JSON.parse(storedAppliedJobs));
    }
  }

  saveAppliedJobsToStorage(): void {
    localStorage.setItem(`appliedJobs_${this.employeeId}`, JSON.stringify([...this.appliedJobs]));
  }

  isJobApplied(jobPosId: number): boolean {
    return this.appliedJobs.has(jobPosId);
  }

  applyForJob(jobPosId: number): void {
    if (this.employeeId === null) {
      console.error('Employee ID not available');
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Employee ID not available. Please try again later.",
        showConfirmButton: true,
        confirmButtonColor: '#800000'
      });
      return;
    }

    const application = {
      employee_id: this.employeeId,
      job_pos_id: jobPosId,
      verified_by_manager: false
    };

    this.jobPostingService.createApplication(application).subscribe({
      next: () => {
        console.log('Application created successfully');
        this.appliedJobs.add(jobPosId);
        this.saveAppliedJobsToStorage();
        
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

        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Something went wrong while applying for the job!",
          showConfirmButton: true,
          confirmButtonColor: '#800000'
        });
      }
    });
  }
}