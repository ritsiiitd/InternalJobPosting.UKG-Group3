import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Application } from '../models/JobPosting.model';

export interface ApplicationDto {
  employee_id: number;
  app_id: number;
  job_pos_id: number;
  verified_by_manager: boolean;
  status: string;
}

export interface EmployeeDto {
  employee_id: number;
  first_name: string;
  last_name: string;
  email: string;
  dob: string;
  role: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  private apiUrl = 'http://localhost:8081/api'; // Adjust this to your API gateway URL

  constructor(private http: HttpClient) {}

  
  getApplicationsByEmployeeId(employee_id: number): Observable<Application[]> {
    return this.http.get<Application[]>(`${this.apiUrl}/applications/byEmployee/${employee_id}`);
  }
 

  getApplicationsForJob(jobId: number): Observable<ApplicationDto[]> {
    return this.http.get<ApplicationDto[]>(`${this.apiUrl}/applications/job/${jobId}`);
  }
  
  getEmployeeDetails(employeeId: number): Observable<EmployeeDto> {
    return this.http.get<EmployeeDto>(`${this.apiUrl}/employees/${employeeId}`);
  }
}