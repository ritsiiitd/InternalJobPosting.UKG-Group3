// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-accepted',
//   standalone: true,
//   imports: [],
//   templateUrl: './accepted.component.html',
//   styleUrl: './accepted.component.css'
// })
// export class AcceptedComponent {

// }
// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-accepted',
//   standalone: true,
//   imports: [],
//   templateUrl: './accepted.component.html',
//   styleUrl: './accepted.component.css'
// })
// export class AcceptedComponent {

// }
import { Component, OnInit } from '@angular/core';
// import { ApplicationService } from '../../services/Application.service';
import { ManagerApplicationService } from '../../services/manager-application.service';
import { ApplicationDetails } from '../../models/Application.model';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-accepted-application',
  imports: [CommonModule,RouterLink, RouterOutlet],
  standalone:true,
  templateUrl: './accepted.component.html',
  styleUrls: ['./accepted.component.css']
})
export class AcceptedApplicationComponent implements OnInit {
  acceptedApplications: ApplicationDetails[] = [];

  constructor(private managerApplicationService: ManagerApplicationService) {}

  ngOnInit(): void {
    this.loadAcceptedApplications();
  }

  loadAcceptedApplications(): void {
    const managerId = 1; // Replace with dynamic value if necessary
    this.managerApplicationService.getAllApplicationsDetailsManager(1).subscribe({
      next: (applications: ApplicationDetails[]) => {
        this.acceptedApplications = applications.filter(app => app.status === 'ACCEPTED');
      },
      error: (error: any) => {
        console.error('Error loading accepted applications:', error);
      }
    });
  }
}
