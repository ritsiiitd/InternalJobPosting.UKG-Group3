import { Routes } from '@angular/router';
import { HrComponent } from './hr/hr.component';
import {LoginComponent} from "./login/login.component";

export const routes: Routes = [
  // { path: 'hr', component: HrComponent },
  // { path: '', redirectTo: '/hr', pathMatch: 'full' },
  {path:'', component:LoginComponent}
];
