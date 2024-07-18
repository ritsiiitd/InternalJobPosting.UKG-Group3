// import { Component, OnInit } from '@angular/core';
// import { ApplicationService } from '../../services/application.service';
// import { Application } from '../../models/JobPosting.model';
// import { CommonModule } from '@angular/common';
// import { RouterLink, RouterOutlet } from '@angular/router';
// import { AuthService } from '../../services/auth.service';

// @Component({
//   selector: 'my-jobs',
//   standalone: true,
//   imports: [CommonModule, RouterLink, RouterOutlet],
//   templateUrl: './my-jobs.component.html',
//   styleUrl: './my-jobs.component.css'
// })


// export class MyJobsComponent implements OnInit{
//   myApplications: Application[] = [];
//   employeeId: number = 3;
  

//   constructor(private applicationService: ApplicationService) {}

//   ngOnInit(): void {
//     this.loadMyApplications();
//   }


//   loadMyApplications(): void {
//     this.applicationService.getApplicationsByEmployeeId(this.employeeId).subscribe({
//       next: (applications: Application[]) => {
//         this.myApplications = applications;
//       },
//       error: (error: any) => {
//         console.error('Error loading applications:', error);
//       }
//     });
//   }
  
// }


import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../services/application.service';
import { Application } from '../../models/JobPosting.model';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'my-jobs',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterOutlet],
  templateUrl: './my-jobs.component.html',
  styleUrl: './my-jobs.component.css'
})
export class MyJobsComponent implements OnInit {
  myApplications: Application[] = [];
  employeeId: number | null = null;

  constructor(
    private applicationService: ApplicationService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.employeeId = this.authService.getCurrentEmployeeId();
    if (this.employeeId !== null) {
      this.loadMyApplications();
    } else {
      console.error('No employee ID available');
      // Handle the case when no employee ID is available
      // You might want to show an error message or redirect
    }
  }

  loadMyApplications(): void {
    if (this.employeeId === null) {
      console.error('Cannot load applications: No employee ID available');
      return;
    }

    this.applicationService.getApplicationsByEmployeeId(this.employeeId).subscribe({
      next: (applications: Application[]) => {
        this.myApplications = applications;
      },
      error: (error: any) => {
        console.error('Error loading applications:', error);
      }
    });
  }
}