import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import { JobFormComponent } from './job-form/job-form.component';
import { JobDetailsComponent } from './job-details/job-details.component';

export const routes: Routes = [
  { path: 'hr', component: HrComponent },
  { path: 'hr/new-job', component: JobFormComponent },
  { path: 'hr/job', component: JobDetailsComponent },

  { path: '', redirectTo: '/hr', pathMatch: 'full' },
];