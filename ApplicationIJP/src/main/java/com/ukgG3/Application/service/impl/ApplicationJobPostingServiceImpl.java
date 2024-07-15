//package com.ukgG3.Application.service.impl;
//
//import com.ukgG3.Application.Dto.EmployeeDto;
//import com.ukgG3.Application.Dto.JobPostingDto;
//import com.ukgG3.Application.service.client.JobPostingFeignClient;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//
//@Service
//@AllArgsConstructor
//public class ApplicationJobPostingServiceImpl {
//
//    private final JobPostingFeignClient jobPostingFeignClient;
//
//    public ResponseEntity<JobPostingDto> fetchJobPosting(Long id){
//        return jobPostingFeignClient.getJobPostingById(id);
//    }
//
//    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
//        return jobPostingFeignClient.getEmployeeById(id);
//    }
//}
