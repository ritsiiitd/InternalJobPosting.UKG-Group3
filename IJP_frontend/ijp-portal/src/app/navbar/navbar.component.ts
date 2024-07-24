import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <nav class="bg-gray-800 p-4">
      <div class="container mx-auto flex justify-between items-center">
        <a (click)="navigateToHome()" class="text-white text-xl font-bold cursor-pointer">IJP Portal</a>
        <ul class="flex space-x-4">
          <li *ngIf="authService.isLoggedIn()">
            <span class="text-white">{{authService.getCurrentUserRole()}}</span>
          </li>
          <li>
            <button *ngIf="authService.isLoggedIn()" (click)="logout()" class="text-white hover:text-gray-300">Logout</button>
          </li>
        </ul>
      </div>
    </nav>
  `,
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  constructor(public authService: AuthService, private router: Router) {}

  ngOnInit() {
    // You can add any initialization logic here if needed
  }

  navigateToHome() {
    if (this.authService.isLoggedIn()) {
      const role = this.authService.getCurrentUserRole();
      switch (role) {
        case 'HR':
          this.router.navigate(['/hr']);
          break;
        case 'MANAGER':
          this.router.navigate(['/manager-dashboard']);
          break;
        case 'EMPLOYEE':
          this.router.navigate(['/candidate-dashboard']);
          break;
        default:
          this.router.navigate(['/']);
      }
    } else {
      this.router.navigate(['/']);
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}