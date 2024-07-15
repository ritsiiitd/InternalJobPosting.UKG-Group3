package com.ukgG3.Application.service.client;

import com.ukgG3.Application.Dto.EmployeeDto;
import com.ukgG3.Application.Dto.JobPostingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("JobPosting")
public interface JobPostingFeignClient {

    @GetMapping("/api/jobPostings/getJobById")
    public ResponseEntity<JobPostingDto> getJobPostingById(@RequestParam Long id);

    @GetMapping("/api/employees/getById")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam Long id);
}






