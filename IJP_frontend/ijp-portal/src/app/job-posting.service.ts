import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

export interface JobPosting {
  id: number;
  title: string;
  description: string;
  isActive: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class JobPostingService {
  private jobPostings: JobPosting[] = [
    { id: 1, title: 'Software Developer', description: 'We are looking for a skilled software developer.', isActive: true },
    { id: 2, title: 'Data Analyst', description: 'Seeking a data analyst to interpret complex data sets.', isActive: true },
  ];

  private jobPostingsSubject = new BehaviorSubject<JobPosting[]>(this.jobPostings);

  constructor() { }

  getJobPostings(): Observable<JobPosting[]> {
    return this.jobPostingsSubject.asObservable();
  }

  addJobPosting(jobPosting: Omit<JobPosting, 'id'>): void {
    const newId = Math.max(...this.jobPostings.map(jp => jp.id)) + 1;
    this.jobPostings.push({ ...jobPosting, id: newId, isActive: true });
    this.jobPostingsSubject.next(this.jobPostings);
  }

  closeJobPosting(id: number): void {
    const index = this.jobPostings.findIndex(jp => jp.id === id);
    if (index !== -1) {
      this.jobPostings[index].isActive = false;
      this.jobPostingsSubject.next(this.jobPostings);
    }
  }

  deleteJobPosting(id: number): void {
    this.jobPostings = this.jobPostings.filter(jp => jp.id !== id);
    this.jobPostingsSubject.next(this.jobPostings);
  }
}