import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import { JobFormComponent } from './job-form/job-form.component';

export const routes: Routes = [
  { path: 'hr', component: HrComponent },
  { path: 'hr/new-job', component: JobFormComponent },
  { path: '', redirectTo: '/hr', pathMatch: 'full' },
  { path: 'manager-dashboard', component: ManagerDashboardComponent, children: [
    { path: 'pending', component: PendingComponent },
    { path: 'accepted', component: AcceptedApplicationComponent },
    { path: 'rejected', component: RejectedApplicationComponent },
    { path: '', redirectTo: 'pending', pathMatch: 'full' }
]}
];


// rahul
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { PendingComponent } from './manager-dashboard/pending/pending.component';
import { AcceptedApplicationComponent } from './manager-dashboard/accepted/accepted.component';
import { RejectedApplicationComponent } from './manager-dashboard/rejected/rejected.component';


// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }



