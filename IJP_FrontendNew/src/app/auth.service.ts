// auth.service.ts
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuthenticated = false;
  private userRole: string | null = null;

  constructor(private router: Router) {}

  login(token: string, role: string) {
    this.isAuthenticated = true;
    this.userRole = role;
    // Optionally store token in local storage or session storage
    localStorage.setItem('access_token', token);
    this.router.navigate(['/dashboard']);
  }

  logout() {
    this.isAuthenticated = false;
    this.userRole = null;
    // Clear token from storage
    localStorage.removeItem('access_token');
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }

  getRole(): string | null {
    return this.userRole;
  }
}
