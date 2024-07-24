package com.ukgG3.JobPosting.controller;


import com.ukgG3.JobPosting.dto.*;
import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.Location;
import com.ukgG3.JobPosting.mapper.EmployeeMapper;
import com.ukgG3.JobPosting.mapper.JobPostingMapper;
import com.ukgG3.JobPosting.mapper.LocationMapper;
import com.ukgG3.JobPosting.service.IJobPostingService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobPostings")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class JobPostingController {
    private static final Logger log = LoggerFactory.getLogger(JobPostingController.class);
    @Autowired
    private final IJobPostingService jobPostingService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JobPostingDto>> getAllJobPostings() {
        List<JobPostingDto> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.status(HttpStatus.OK).body(jobPostings);
    }


//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getJobById")
    public ResponseEntity<JobPostingDto> getJobPostingById(@RequestParam Long id) {
        JobPostingDto jobPostingDto = jobPostingService.getJobPostingById(id);
        if (jobPostingDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jobPostingDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addJob")
    public ResponseEntity<JobPostingDto> createJobPosting(@RequestBody JobPostingDto jobPostingDTO) {
        System.out.println("Request made here");
        System.out.println(jobPostingDTO.getCreatedBy());
        System.out.println(jobPostingDTO.getJobPosId());//null ari hai
        System.out.println(jobPostingDTO.getDesignation());
        System.out.println(jobPostingDTO.getDescription());
        System.out.println(jobPostingDTO.getDeadline());
        System.out.println(jobPostingDTO.getLocations());
        System.out.println(jobPostingDTO.getIsActive());
        System.out.println(jobPostingDTO.getCodingLanguages());
        System.out.println(jobPostingDTO.getIsActive());
        System.out.println(jobPostingDTO.getMaxSal());
        JobPostingDto isSaved = jobPostingService.saveJobPosting(jobPostingDTO);
        if (isSaved != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(isSaved);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jobPostingDTO);
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteJob")
    public ResponseEntity<Void> deleteJobPosting(@RequestParam Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.noContent().build();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/closeJobPosting")
    public ResponseEntity<ResponseDto> updateIsActive(@RequestParam Long id) {
        boolean isUpdated = jobPostingService.updateIsActive(id, false);
        System.out.println("Closing a job posting");
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200", "Job Posting status updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("404", "Job Posting not found"));
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllLocations")
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        List<LocationDto> locationDtos= jobPostingService.getAllLocations();
        if (locationDtos != null) {
            return ResponseEntity.status(HttpStatus.OK).body(locationDtos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllCodingLanguages")
    public ResponseEntity<List<CodingLanguageDto>> getAllCodingLanguages() {
        List<CodingLanguageDto> codingLanguageDtos= jobPostingService.getAllCodingLang();
        if (codingLanguageDtos != null) {
            return ResponseEntity.status(HttpStatus.OK).body(codingLanguageDtos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getCodingLanguageById")
    public ResponseEntity<CodingLanguageDto> getCodingLanguageById(@RequestParam Long id) {
        CodingLanguageDto codingLanguageDto= jobPostingService.getCodingLangById(id);
        if (codingLanguageDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(codingLanguageDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getLocationById")
    public ResponseEntity<LocationDto> getLocationById(@RequestParam Long id) {
        LocationDto locationDto= jobPostingService.getLocationById(id);
        if (locationDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(locationDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //for location and coding language
    @GetMapping("/getAllJobsString")
    public ResponseEntity<List<JobPostingGetAllDto>> getAllJobPostingsAll() {
        List<JobPostingGetAllDto> jobPostings = jobPostingService.getAllJobPostingsAll();
        return ResponseEntity.status(HttpStatus.OK).body(jobPostings);
    }

}
