import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import { JobFormComponent } from './job-form/job-form.component';
import { LoginComponent } from './login/login.component';
import { ManagerDashboardComponent } from './manager-dashboard/manager-dashboard.component';
import { PendingComponent } from './manager-dashboard/pending/pending.component';
import { AcceptedApplicationComponent } from './manager-dashboard/accepted/accepted.component';
import { RejectedApplicationComponent } from './manager-dashboard/rejected/rejected.component';
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