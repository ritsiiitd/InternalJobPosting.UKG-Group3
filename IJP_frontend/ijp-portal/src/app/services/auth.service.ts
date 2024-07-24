// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map, BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';

interface Employee {
  email: string;
  password: string;
  role: string;
  employee_id: number;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8072/api/employees/getAll';
  private currentUserSubject: BehaviorSubject<{ role: string, employee_id: number } | null>;

  constructor(private http: HttpClient, private router: Router) {
    this.currentUserSubject = new BehaviorSubject<{ role: string, employee_id: number } | null>(
      JSON.parse(localStorage.getItem('currentUser') || 'null')
    );
  }

  get currentUser() {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string): Observable<{ role: string, employee_id: number }> {
    return this.http.get<Employee[]>(this.apiUrl).pipe(
      map(employees => {
        const employee = employees.find(e => e.email === email && e.password === password);
        if (employee) {
          const user = { role: employee.role, employee_id: employee.employee_id };
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          return user;
        }
        throw new Error('Invalid credentials');
      })
    );
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
    this.router.navigate(['/login']);
  }

  getCurrentEmployeeId(): number | null {
    return this.currentUser?.employee_id || null;
  }

  // login(email: string, password: string): Observable<{ role: string, employee_id: number }> {
  //   return this.http.get<Employee[]>(this.apiUrl).pipe(
  //     map(employees => {
  //       const employee = employees.find(e => e.email === email && e.password === password);
  //       if (employee) {
  //         const user = { role: employee.role, employee_id: employee.employee_id };
  //         localStorage.setItem('currentUser', JSON.stringify(user));
  //         this.currentUserSubject.next(user);
  //         return user;
  //       }
  //       throw new Error('Invalid credentials');
  //     })
  //   );
  // }

  // logout() {
  //   localStorage.removeItem('currentUser');
  //   this.currentUserSubject.next(null);
  //   this.router.navigate(['/login']);
//  }

  isLoggedIn(): boolean {
    return !!this.currentUser;
  }

  hasRole(role: string): boolean {
    return this.currentUser?.role === role;
  }

  // In auth.service.ts

getCurrentUserRole(): string | null {
  return this.currentUser?.role || null;
}

  getRouteForRole(role: string): string {
    switch (role) {
      case 'HR':
        return '/hr';
      case 'MANAGER':
        return '/manager-dashboard';
      case 'EMPLOYEE':
        return '/candidate-dashboard';
      default:
        return '/login';
    }
  }
}