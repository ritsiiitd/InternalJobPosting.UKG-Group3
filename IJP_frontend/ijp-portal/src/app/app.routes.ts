import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import { JobFormComponent } from './job-form/job-form.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { PendingComponent } from './manager-dashboard/pending/pending.component';
import { AcceptedApplicationComponent } from './manager-dashboard/accepted/accepted.component';
import { RejectedApplicationComponent } from './manager-dashboard/rejected/rejected.component';
import { JobApplicationsComponent } from './job-applications-component/job-applications-component.component';
import { CandidateDashboardComponent } from './candidate-dashboard/candidate-dashboard.component';
import { AllJobsComponent } from './candidate-dashboard/all-jobs/all-jobs.component';
import { MyJobsComponent } from './candidate-dashboard/my-jobs/my-jobs.component';


export const routes: Routes = [
  { path: 'hr', component: HrComponent },
  { path: 'hr/new-job', component: JobFormComponent },
  { path: 'hr/job', component: JobDetailsComponent },

  { path: 'job/:id/applications', component: JobApplicationsComponent },

  { path: 'candidate-dashboard', component: CandidateDashboardComponent, children:[
      {path: 'all-jobs', component: AllJobsComponent},
      {path: 'my-jobs', component: MyJobsComponent},
      { path: '', redirectTo: 'all-jobs', pathMatch: 'full' }
  ]}, 

  { path: '', redirectTo: '/hr', pathMatch: 'full' },
  { path: 'manager-dashboard', component: ManagerDashboardComponent, children: [
    { path: 'pending', component: PendingComponent },
    { path: 'accepted', component: AcceptedApplicationComponent },
    { path: 'rejected', component: RejectedApplicationComponent },
    { path: '', redirectTo: 'pending', pathMatch: 'full' }
]}
];


 