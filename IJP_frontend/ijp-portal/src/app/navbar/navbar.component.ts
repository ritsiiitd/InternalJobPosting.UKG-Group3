import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule], // Add CommonModule and RouterModule here
  template: `<nav class="bg-gray-800 p-4">
    <div class="container mx-auto flex justify-between items-center">
      <a routerLink="/" class="text-white text-xl font-bold">IJP Portal</a>
      <ul class="flex space-x-4">
        <li><a routerLink="/hr" class="text-white hover:text-gray-300">HR</a></li>
        <!-- Add more nav items as needed -->
        <button *ngIf="authService.isLoggedIn()" (click)="logout()" class="text-white hover:text-gray-300">Logout</button>
      </ul>
    </div>
  </nav>`,
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  constructor(public authService: AuthService) {} // Change to public

  logout() {
    this.authService.logout();
  }
}