package com.ukgG3.Application.service;

import com.ukgG3.Application.Dto.EmployeeDto;
import com.ukgG3.Application.Dto.JobPostingDto;
import org.springframework.http.ResponseEntity;

public interface IJobPostingDetails {
    ResponseEntity<JobPostingDto> getJobPostingById(Long id);
    ResponseEntity<EmployeeDto> getEmployeeById(Long id);
}
