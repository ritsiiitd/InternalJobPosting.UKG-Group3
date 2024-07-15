package com.ukgG3.Application.controller;


import com.ukgG3.Application.Dto.EmployeeDto;
import com.ukgG3.Application.Dto.JobPostingDto;
import com.ukgG3.Application.service.impl.JobPostingDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class GetJobPostingController {

    @Autowired
    private final JobPostingDetailsServiceImpl jobPostingDetailsServiceImpl;

    @GetMapping("jobPostings/getJobById")
    public ResponseEntity<JobPostingDto> getJobPostingById(@RequestParam Long id) {
        return jobPostingDetailsServiceImpl.getJobPostingById(id);
    }

    @GetMapping("employees/getById")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam Long id) {
        return jobPostingDetailsServiceImpl.getEmployeeById(id);
    }
}










