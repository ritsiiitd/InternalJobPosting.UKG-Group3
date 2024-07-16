package com.ukgG3.JobPosting.controller;


import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import com.ukgG3.JobPosting.service.IJobPostingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
@AllArgsConstructor
public class JobPostingController {
    @Autowired
    private final IJobPostingService jobPostingService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobPostingDto>> getAllJobPostings() {
        List<JobPostingDto> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.status(HttpStatus.OK).body(jobPostings);
    }

    @GetMapping("/getJobById")
    public ResponseEntity<JobPostingDto> getJobPostingById(@RequestParam Long id) {
        JobPostingDto jobPostingDto = jobPostingService.getJobPostingById(id);
        if (jobPostingDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jobPostingDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addJob")
    public ResponseEntity<ResponseDto> createJobPosting(@RequestBody JobPostingDto jobPostingDTO) {
        boolean isSaved = jobPostingService.saveJobPosting(jobPostingDTO);
        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Job Posting Created Successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("400", "Failed to Create Job Posting"));
        }
    }


    @DeleteMapping("/deleteJob")
    public ResponseEntity<Void> deleteJobPosting(@RequestParam Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/closeJobPosting")
    public ResponseEntity<ResponseDto> updateIsActive(@RequestParam Long id) {
        boolean isUpdated = jobPostingService.updateIsActive(id, false);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200", "Job Posting status updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("404", "Job Posting not found"));
        }
    }
}
