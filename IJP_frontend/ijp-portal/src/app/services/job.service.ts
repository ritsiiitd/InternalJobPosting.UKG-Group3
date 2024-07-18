import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { CodingLanguage, Job } from '../models/job.model';


export interface Location {
    locationId: number;
    name: string;
}


@Injectable({
  providedIn: 'root'
})

export class JobService {
  private apiUrl = 'http://localhost:8072/api/jobPostings'; // Gateway URL
  private jobsSubject = new BehaviorSubject<Job[]>([]);

  constructor(private http: HttpClient) {
    this.fetchJobs();
  }

  private fetchJobs(): void {
    this.http.get<Job[]>(`${this.apiUrl}/getAllJobs`).subscribe(
      jobs => this.jobsSubject.next(jobs),
      error => console.error('Error fetching jobs:', error)
    );
  }

  getJobs(): Observable<Job[]> {
    return this.jobsSubject.asObservable();
  }

  toggleJobStatus(id: number): void {
    this.http.put<Job>(`${this.apiUrl}/toggleJobStatus/${id}`, {}).subscribe(
      updatedJob => {
        const currentJobs = this.jobsSubject.value;
        const updatedJobs = currentJobs.map(job => 
          job.jobPosId === id ? { ...job, isActive: !job.isActive } : job
        );
        this.jobsSubject.next(updatedJobs);
      },
      error => console.error('Error toggling job status:', error)
    );
  }

  deleteJob(id: number): void {
    this.http.delete(`${this.apiUrl}/deleteJob/${id}`).subscribe(
      () => {
        const currentJobs = this.jobsSubject.value;
        const updatedJobs = currentJobs.filter(job => job.jobPosId !== id);
        this.jobsSubject.next(updatedJobs);
      },
      error => console.error('Error deleting job:', error)
    );
  }

  addJob(job: Job): Observable<Job> {
    return this.http.post<Job>(`${this.apiUrl}/addJob`, job);
  }

  getLocations(): Observable<Location[]> {
    const locations = this.http.get<Location[]>(`${this.apiUrl}/getAllLocations`)
    console.log("Service locations: ", locations.forEach(location => console.log(location)));
    return locations;
  }
  
  getCodingLanguages(): Observable<CodingLanguage[]> {
    const languages = this.http.get<CodingLanguage[]>(`${this.apiUrl}/getAllCodingLanguages`)
    console.log("Service languages: ", languages.forEach(language => console.log(language)));
    return languages;
  }


}