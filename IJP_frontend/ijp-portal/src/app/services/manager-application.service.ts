import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApplicationDetails } from '../models/Application.model';

@Injectable({
  providedIn: 'root'
})
export class ManagerApplicationService {
  private apiUrl = 'http://localhost:8082/api/jobpost'; 
  // Update with your actual API URL
    private apiUrlVerify='http://localhost:8082/api/jobpost/applications/';
    private apiUrlVerifyRejected='http://localhost:8082/api/jobpost/applications/';
  constructor(private http: HttpClient) {}

  getAllApplicationsDetailsManager(mgId: number): Observable<ApplicationDetails[]> {
    return this.http.get<ApplicationDetails[]>(`${this.apiUrl}/getAllApplicationsDetailsManager/${mgId}`);
  }

  acceptApplication(appId: number): Observable<void> {
    return this.http.put<void>(`${this.apiUrlVerify}${appId}/verifyByManager`, {});
  }

  rejectApplication(appId: number): Observable<void> {
    return this.http.put<void>(`${this.apiUrlVerify}${appId}/verifyByManagerRejected`, {});
  }
}
