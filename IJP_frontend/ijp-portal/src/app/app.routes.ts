import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import { JobFormComponent } from './job-form/job-form.component';

export const routes: Routes = [
  { path: 'hr', component: HrComponent },
  { path: 'hr/new-job', component: JobFormComponent },
  { path: '', redirectTo: '/hr', pathMatch: 'full' },
];