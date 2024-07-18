// import { Component } from '@angular/core';
 
// @Component({
//   selector: 'app-pending',
//   standalone: true,
//   imports: [],
//   templateUrl: './pending.component.html',
//   styleUrl: './pending.component.css'
// })
// export class PendingComponent {
 
// }
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManagerApplicationService } from '../../services/manager-application.service';
import { ApplicationDetails } from '../../models/Application.model';
import { RouterLink, RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-pending',
  standalone: true,
  imports: [CommonModule,RouterLink, RouterOutlet],
  templateUrl: './pending.component.html',
  styleUrls: ['./pending.component.css']
})
export class PendingComponent implements OnInit {
  pendingApplications: ApplicationDetails[] = [];
 
  constructor(private managerApplicationService: ManagerApplicationService) {}
 
  ngOnInit(): void {
    this.loadPendingApplications();
  }
 
  loadPendingApplications(): void {
    this.managerApplicationService.getAllApplicationsDetailsManager(1) // Update with the actual manager ID
      .subscribe({
        next: (applications: ApplicationDetails[]) => {
          this.pendingApplications = applications.filter(app => app.status === 'pending');
        },
        error: (error: any) => {
          console.error('Error loading pending applications:', error);
        }
      });
  }
 
  acceptApplication(appId: number): void {
    this.managerApplicationService.acceptApplication(appId).subscribe({
      next: () => {
        this.pendingApplications = this.pendingApplications.filter(app => app.app_id !== appId);
      },
      error: (error: any) => {
        console.error('Error accepting application:', error);
      }
    });
  }
 
  rejectApplication(appId: number): void {
    this.managerApplicationService.rejectApplication(appId).subscribe({
      next: () => {
        this.pendingApplications = this.pendingApplications.filter(app => app.app_id !== appId);
      },
      error: (error: any) => {
        console.error('Error rejecting application:', error);
      }
    });
  }
}
 
 