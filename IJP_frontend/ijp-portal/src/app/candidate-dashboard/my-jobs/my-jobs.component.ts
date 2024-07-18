import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../services/application.service';
import { Application } from '../../models/JobPosting.model';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'my-jobs',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterOutlet],
  templateUrl: './my-jobs.component.html',
  styleUrl: './my-jobs.component.css'
})

export class MyJobsComponent implements OnInit{
  myApplications: Application[] = [];
  employeeId: number = 3;

  constructor(private applicationService: ApplicationService) {}

  ngOnInit(): void {
    this.loadMyApplications();
  }


  loadMyApplications(): void {
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
