import { Routes } from '@angular/router';
import { HrDashboardComponent } from './hr-dashboard/hr-dashboard.component';
import { JobPostingFormComponent } from './job-posting-form/job-posting-form.component';
import { JobApplicationsComponent } from './job-applications/job-applications.component';

export const routes: Routes = [
  { path: 'hr-dashboard', component: HrDashboardComponent },
  { path: 'add-job-posting', component: JobPostingFormComponent },
  { path: 'job-applications/:id', component: JobApplicationsComponent },
  { path: '', redirectTo: '/hr-dashboard', pathMatch: 'full' },
];