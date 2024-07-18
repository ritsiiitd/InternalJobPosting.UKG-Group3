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

import { LoginComponent } from './login/login.component';

import { AuthGuard } from './services/auth.guard';
import { UnauthorizedComponent } from './unauthorized/unauthorized.component';

export const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { 
    path: 'hr', 
    component: HrComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['HR'] }
  },
  { 
    path: 'hr/new-job', 
    component: JobFormComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['HR'] }
  },
  { 
    path: 'hr/job', 
    component: JobFormComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['HR'] }
  },
  

  { path: 'job/:id/applications', component: JobApplicationsComponent,canActivate: [AuthGuard],
    data: { roles: ['HR'] } },

  { path: 'candidate-dashboard', canActivate: [AuthGuard],
    data: { roles: ['EMPLOYEE'] }, component: CandidateDashboardComponent, children:[
      {path: 'all-jobs', component: AllJobsComponent},
      {path: 'my-jobs', component: MyJobsComponent},
      { path: '', redirectTo: 'all-jobs', pathMatch: 'full' }
  ]}, 


  { 
    path: 'manager-dashboard', 
    component: ManagerDashboardComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['MANAGER'] },
    children: [
      { path: 'pending', component: PendingComponent },
      { path: 'accepted', component: AcceptedApplicationComponent },
      { path: 'rejected', component: RejectedApplicationComponent },
      { path: '', redirectTo: 'pending', pathMatch: 'full' }
    ]
  },
  { path: 'unauthorized', component: UnauthorizedComponent },
  { path: '**', redirectTo: '/unauthorized' }
];



// export const routes: Routes = [
//   { path: 'login', component: LoginComponent },
//   { path: '', redirectTo: '/login', pathMatch: 'full' },
//   { 
//     path: 'hr', 
//     component: HrComponent, 
//     canActivate: [AuthGuard],
//     data: { roles: ['HR'] }
//   },
//   { 
//     path: 'hr/new-job', 
//     component: JobFormComponent, 
//     canActivate: [AuthGuard],
//     data: { roles: ['HR'] }
//   },
//   { 
//     path: 'manager-dashboard', 
//     component: ManagerDashboardComponent, 
//     canActivate: [AuthGuard],
//     data: { roles: ['MANAGER'] },
//     children: [
//       { path: 'pending', component: PendingComponent },
//       { path: 'accepted', component: AcceptedApplicationComponent },
//       { path: 'rejected', component: RejectedApplicationComponent },
//       { path: '', redirectTo: 'pending', pathMatch: 'full' }
//     ]
//   },
//   { path: 'unauthorized', component: UnauthorizedComponent },
//   { path: '**', redirectTo: '/unauthorized' }
// ];
 