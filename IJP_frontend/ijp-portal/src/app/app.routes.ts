import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';

export const routes: Routes = [
  { path: 'hr', component: HrComponent },
  { path: '', redirectTo: '/hr', pathMatch: 'full' },
];