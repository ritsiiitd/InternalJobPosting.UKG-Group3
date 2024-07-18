import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobApplicationsComponentComponent } from './job-applications-component.component';

describe('JobApplicationsComponentComponent', () => {
  let component: JobApplicationsComponentComponent;
  let fixture: ComponentFixture<JobApplicationsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JobApplicationsComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JobApplicationsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
