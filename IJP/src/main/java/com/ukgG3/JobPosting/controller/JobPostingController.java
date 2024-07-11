package com.ukgG3.JobPosting.controller;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import com.ukgG3.JobPosting.service.IJobPostingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
//@AllArgsConstructor
public class JobPostingController {


    @Qualifier("IJobPostingService")
    private IJobPostingService iJobPostingService;

    @PostMapping("/postApplication")
    public ResponseEntity<ResponseDto> postApplication(@RequestBody JobPostingDto jobPostingDto) {

        iJobPostingService.postApplication(jobPostingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Created Successfully"));
    }
}
