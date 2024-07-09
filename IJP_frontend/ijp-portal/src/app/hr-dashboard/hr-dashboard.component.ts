import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { JobPostingService, JobPosting } from '../job-posting.service';

@Component({
  selector: 'app-hr-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './hr-dashboard.component.html',
  styleUrls: ['./hr-dashboard.component.css']
})
export class HrDashboardComponent implements OnInit {
  jobPostings: JobPosting[] = [];

  constructor(private jobPostingService: JobPostingService) { }

  ngOnInit(): void {
    this.jobPostingService.getJobPostings().subscribe(postings => {
      this.jobPostings = postings;
    });
  }

  closeJobPosting(id: number): void {
    this.jobPostingService.closeJobPosting(id);
  }

  deleteJobPosting(id: number): void {
    this.jobPostingService.deleteJobPosting(id);
  }
}