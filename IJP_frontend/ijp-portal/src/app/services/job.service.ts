import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { CodingLanguage, Job } from '../models/job.model';
import { map, tap } from 'rxjs/operators';
import { ApplicationDto, EmployeeDto } from './application.service';

export interface Location {
    locationId: number;
    name: string;
}

interface ResponseDto {
  code: string;
  message: string;
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

  // deleteJob(id: number): void {
  //   this.http.delete(`${this.apiUrl}/deleteJob/${id}`).subscribe(
  //     () => {
  //       const currentJobs = this.jobsSubject.value;
  //       const updatedJobs = currentJobs.filter(job => job.jobPosId !== id);
  //       this.jobsSubject.next(updatedJobs);
  //     },
  //     error => console.error('Error deleting job:', error)
  //   );
  // }

  addJob(job: Omit<Job, 'jobPosId'>): Observable<Job> {
    return this.http.post<Job>(`${this.apiUrl}/addJob`, job).pipe(
      tap(newJob => {
        console.log('New job added:', newJob);
        const currentJobs = this.jobsSubject.value;
        const updatedJobs = [...currentJobs, newJob];
        console.log('Updated jobs list:', updatedJobs);
        this.jobsSubject.next(updatedJobs);
      })
    );
  }
  
  private fetchJobs(): void {
    console.log('Fetching jobs...');
    this.http.get<Job[]>(`${this.apiUrl}/getAllJobs`).subscribe(
      jobs => {
        console.log('Fetched jobs:', jobs);
        this.jobsSubject.next(jobs);
      },
      error => console.error('Error fetching jobs:', error)
    );
  }


  getJobById(id: number): Observable<Job> {
    console.log("Getting job with id: ", id);
    
    const params = new HttpParams().set('id', id.toString());
    const job = this.http.get<Job>(`${this.apiUrl}/getJobById`, { params })
    console.log("Getting job: ", job);
    return job;
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



  // job.service.ts
  getLocationById(id: number): Observable<Location> {
    console.log("Service location: fetching location...... ");
    const location = this.http.get<Location>(`${this.apiUrl}/getLocationById/${id}`);
    console.log("Service location: ", location);
    return location;
  }

  getCodingLanguageById(id: number): Observable<CodingLanguage> {
    return this.http.get<CodingLanguage>(`${this.apiUrl}/getCodingLanguageById/${id}`);
  }


  closeJob(id: number): Observable<ResponseDto> {
    const params = new HttpParams().set('id', id.toString());
    return this.http.put<ResponseDto>(`${this.apiUrl}/closeJobPosting`,null, { params })
      .pipe(
        tap(() => {
            const currentJobs = this.jobsSubject.value;
            const updatedJobs = currentJobs.map(job => 
              job.jobPosId === id ? { ...job, isActive: false } : job
            );
            this.jobsSubject.next(updatedJobs);
        })
      );
  }

  deleteJob(id: number): Observable<void> {
    const params = new HttpParams().set('id', id.toString());
    return this.http.delete<void>(`${this.apiUrl}/deleteJob`, { params })
      .pipe(
        tap(() => {
          const currentJobs = this.jobsSubject.value;
          const updatedJobs = currentJobs.filter(job => job.jobPosId !== id);
          this.jobsSubject.next(updatedJobs);
        })
      );
  }

  getApplicationsByJobId(jobId: number): Observable<ApplicationDto[]> {
    return this.http.get<ApplicationDto[]>(`${this.apiUrl}/applications/job/${jobId}`);
  }

  getEmployeeById(employeeId: number): Observable<EmployeeDto> {
    return this.http.get<EmployeeDto>(`${this.apiUrl}/employees/${employeeId}`);
  }

  // getJobById(jobId: number): Observable<Job> {
  //   return this.http.get<Job>(`${this.apiUrl}/jobs/${jobId}`);
  // }

}