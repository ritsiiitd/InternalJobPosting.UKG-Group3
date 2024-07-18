// import { Component } from '@angular/core';
 
// @Component({
//   selector: 'app-rejected',
//   standalone: true,
//   imports: [],
//   templateUrl: './rejected.component.html',
//   styleUrl: './rejected.component.css'
// })
// export class RejectedComponent {
 
// }
 
// import { Component } from '@angular/core';
 
// @Component({
//   selector: 'app-rejected',
//   standalone: true,
//   imports: [],
//   templateUrl: './rejected.component.html',
//   styleUrl: './rejected.component.css'
// })
// export class RejectedComponent {
 
// }
 
import { Component, OnInit } from '@angular/core';
import { ManagerApplicationService } from '../../services/manager-application.service';
import { ApplicationDetails } from '../../models/Application.model';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-rejected-application',
  templateUrl: './rejected.component.html',
  standalone:true,
  imports: [CommonModule,RouterLink, RouterOutlet],
  styleUrls: ['./rejected.component.css']
})
export class RejectedApplicationComponent implements OnInit {
  rejectedApplications: ApplicationDetails[] = [];
 
  constructor(private managerApplicationService: ManagerApplicationService) {}
  
  ngOnInit(): void {
    this.loadRejectedApplications();
  }
 
  loadRejectedApplications(): void {
    const managerId = 1; // Replace with dynamic value if necessary
    this.managerApplicationService.getAllApplicationsDetailsManager(managerId).subscribe({
      next: (applications: ApplicationDetails[]) => {
        this.rejectedApplications = applications.filter(app => app.status === 'REJECTED');
      },
      error: (error: any) => {
        console.error('Error loading rejected applications:', error);
      }
    });
  }
}
 
 