// import { Component } from '@angular/core';
 
// @Component({
//   selector: 'app-manager-dashboard',
//   standalone: true,
//   imports: [],
//   templateUrl: './manager-dashboard.component.html',
//   styleUrl: './manager-dashboard.component.css'
// })
// export class ManagerDashboardComponent {
 
// }
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';
 
@Component({
  selector: 'app-manager-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule, RouterLink, RouterOutlet],
  templateUrl: './manager-dashboard.component.html',
  styleUrls: ['./manager-dashboard.component.css']
})
export class ManagerDashboardComponent {
}
 
 