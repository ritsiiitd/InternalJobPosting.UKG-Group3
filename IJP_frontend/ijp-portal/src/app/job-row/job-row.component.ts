import { Component, Input, Output, EventEmitter} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Job } from '../models/job.model';
import { JobService } from '../services/job.service';
import { Router } from '@angular/router';





@Component({
  selector: 'app-job-row',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="bg-white shadow-md rounded-lg p-6 mb-4 flex justify-between items-center" >
      <div>
        <h3 class="text-xl font-bold mb-2" (click)="viewJobDetails()">{{ job.description }} </h3>
        <p class="text-gray-600">{{ job.description }}</p>
        <p class="text-sm text-gray-500"> Salary: {{ job.minSal }} - {{ job.maxSal }}</p>
        <p class="text-sm text-gray-500"> Deadline: {{ job.deadline | date }} </p>
      </div>
      <div>
      <button 
          *ngIf="job.isActive"
          class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2" 
          (click)="onCloseJob()"
        >
          Close Job
        </button>
        <button 
          *ngIf="!job.isActive"
          class="bg-orange-500 text-white font-bold py-2 px-4 rounded mr-2 cursor-not-allowed" 
          disabled
        >
          Closed
        </button>
        <button 
        class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
        (click)="onDeleteJob()"
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

  @Output() closeJob = new EventEmitter<number>();
  @Output() deleteJob = new EventEmitter<number>();


  constructor(private router: Router, private jobService: JobService) {}

  viewJobDetails() {
    this.router.navigate(['/hr/job'], { queryParams: { id: this.job.jobPosId } });
  }

  onCloseJob() {
    this.closeJob.emit(this.job.jobPosId);
  }

  onDeleteJob() {
    this.deleteJob.emit(this.job.jobPosId);
  }

}
