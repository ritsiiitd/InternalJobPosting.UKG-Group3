import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Job } from '../models/job.model';
import { JobService } from '../services/job.service';

@Component({
  selector: 'app-job-row',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="bg-white shadow-md rounded-lg p-6 mb-4 flex justify-between items-center">
      <div>
        <h3 class="text-xl font-bold mb-2">{{ job.description }}</h3>
        <p class="text-gray-600">{{ job.description }}</p>
        <p class="text-sm text-gray-500"> Salary: {{ job.minSal }} - {{ job.maxSal }}</p>
        <p class="text-sm text-gray-500"> Deadline: {{ job.deadline | date }} </p>
      </div>
      <div>
        <button 
          (click)="onToggleStatus()"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2"
        >
          {{ job.isActive ? 'Close Job' : 'Reopen Job' }}
        </button>
        <button 
          (click)="onDeleteJob()"
          class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
        >
          Delete Job
        </button>
      </div>
    </div>
  `,
  styleUrls: ['./job-row.component.css']
})
export class JobRowComponent {
  @Input() job!: Job;

  constructor(private jobService: JobService) {}

  onToggleStatus() {
    this.jobService.toggleJobStatus(this.job.jobPosId);
  }

  onDeleteJob() {
    this.jobService.deleteJob(this.job.jobPosId);
  }
}