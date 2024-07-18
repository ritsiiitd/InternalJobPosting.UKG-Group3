// job-applications.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { JobService } from '../services/job.service';
import { ApplicationDto } from '../services/application.service';
import { EmployeeDto } from '../services/application.service';
import { Job } from '../models/job.model';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-job-applications',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="container mx-auto px-4 py-8">
      <h2 class="text-2xl font-bold mb-4">Applications for {{ jobPosting?.designation }}</h2>
      <table class="min-w-full bg-white">
        <thead>
          <tr>
            <th class="py-2 px-4 border-b">Applicant Name</th>
            <th class="py-2 px-4 border-b">Email</th>
            <th class="py-2 px-4 border-b">Status</th>
            <th class="py-2 px-4 border-b">Verified by Manager</th>
          </tr>
        </thead>
        <tbody>
          <tr *ngFor="let application of applications">
            <td class="py-2 px-4 border-b">{{ getEmployeeName(application.employee_id) }}</td>
            <td class="py-2 px-4 border-b">{{ getEmployeeEmail(application.employee_id) }}</td>
            <td class="py-2 px-4 border-b">{{ application.status }}</td>
            <td class="py-2 px-4 border-b">{{ application.verified_by_manager ? 'Yes' : 'No' }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  `,
  styleUrls: ['./job-applications-component.component.css']
})
export class JobApplicationsComponent implements OnInit {
  applications: ApplicationDto[] = [];
  employees: Map<number, EmployeeDto> = new Map();
  jobPosting: Job | null = null;

  constructor(
    private route: ActivatedRoute,
    private jobService: JobService
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      const jobId = +params['id'];
      if (jobId) {
        this.loadData(jobId);
      }
    });
  }

  loadData(jobId: number) {
    forkJoin({
      applications: this.jobService.getApplicationsByJobId(jobId),
      jobPosting: this.jobService.getJobById(jobId)
    }).subscribe(
      result => {
        this.applications = result.applications;
        this.jobPosting = result.jobPosting;
        this.loadEmployeeDetails();
      },
      error => console.error('Error fetching data:', error)
    );
  }

  loadEmployeeDetails() {
    const employeeIds = [...new Set(this.applications.map(app => app.employee_id))];
    employeeIds.forEach(id => {
      this.jobService.getEmployeeById(id).subscribe(
        employee => this.employees.set(id, employee),
        error => console.error(`Error fetching employee ${id}:`, error)
      );
    });
    console.log("THESE APPLICATIONS ",this.applications);
    console.log("THIS JOB ",this.jobPosting);
    console.log("THESE CANDIDATES ",this.employees);
    
  }

  getEmployeeName(employeeId: number): string {
    const employee = this.employees.get(employeeId);
    return employee ? `${employee.first_name} ${employee.last_name}` : 'Loading...';
  }

  getEmployeeEmail(employeeId: number): string {
    const employee = this.employees.get(employeeId);
    return employee ? employee.email : 'Loading...';
  }
}