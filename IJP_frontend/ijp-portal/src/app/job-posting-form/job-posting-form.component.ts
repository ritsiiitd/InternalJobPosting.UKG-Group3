import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { JobPostingService } from '../job-posting.service';

@Component({
  selector: 'app-job-posting-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './job-posting-form.component.html',
  styleUrls: ['./job-posting-form.component.css']
})
export class JobPostingFormComponent {
  newJobPosting = {
    title: '',
    description: ''
  };

  constructor(
    private jobPostingService: JobPostingService,
    private router: Router
  ) {}

  onSubmit() {
    if (this.newJobPosting.title && this.newJobPosting.description) {
      this.jobPostingService.addJobPosting(this.newJobPosting);
      this.router.navigate(['/hr-dashboard']);
    }
  }
}