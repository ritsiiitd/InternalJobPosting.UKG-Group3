import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../models/JobPosting.model';
import { Application } from '../models/JobPosting.model';
 
@Injectable({
    providedIn: 'root',
    
  })
export class JobPostingService {
  private apiUrl = 'http://localhost:8082/api/';
 
  constructor(private http: HttpClient) {}
 
  getAllJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(`${this.apiUrl}jobPostings/getAllJobs`);
  }
  createApplication(application: Application): Observable<Application> {
    return this.http.post<Application>(`${this.apiUrl}jobpost/createapplications`, application);
  }
 
  // addJob(job: Job): Observable<any> {
  //   return this.http.post(`${this.apiUrl}/addJob`, job);
  // }
}
 