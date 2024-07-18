package com.ukgG3.JobPosting.controller;


import com.ukgG3.JobPosting.dto.ApplicationDetailsDto;
import com.ukgG3.JobPosting.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import com.ukgG3.JobPosting.service.impl.ApplicationFeignClientImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Apply CORS to all methods in this controller
public class GetApplicationController {
    private final ApplicationFeignClientImpl applicationFeignClientImpl;

    @GetMapping("/jobpost/applications/{id}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
        ApplicationDto applicationDto = applicationFeignClientImpl.getApplicationById(id);

        System.out.println(id);
        return ResponseEntity.ok(applicationDto);
    }

    @GetMapping("/jobpost/getApplications")
        public ResponseEntity<String> getApplications(){
            return ResponseEntity.status(HttpStatus.OK).body("Applications");
    }

    @GetMapping("/jobpost/getAllApplications")
    public List<ApplicationDto> getAllApplications() {



        return applicationFeignClientImpl.getAllApplications();
    }


    @GetMapping("/jobpost/getAllApplicationsDetailsManager/{mgId}")
    public List<ApplicationDetailsDto> getAllApplicationsDetailsManager(@PathVariable Long mgId) {
        List<ApplicationDetailsDto> applicationDetailsDto=applicationFeignClientImpl.getAllApplicationsDetailsManager(mgId);
        return applicationDetailsDto;


    }
    @GetMapping("/jobpost/getAllApplicationsDetails/")
    public List<ApplicationDetailsDto> getAllApplicationsDetails() {
        List<ApplicationDetailsDto> applicationDetailsDto=applicationFeignClientImpl.getAllApplicationsDetails();
        return applicationDetailsDto;


    }

    @PostMapping("/jobpost/createapplications")
    public ResponseEntity<ResponseDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        ResponseDto responseDto = applicationFeignClientImpl.createApplication(applicationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

//    @GetMapping("/jobpost/applications/{id}")
//    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
//        ApplicationDto applicationDto = applicationFeignClientImpl.getApplicationById(id);
//        return ResponseEntity.ok(applicationDto);
//    }

    @DeleteMapping("/jobpost/deleteApplications/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationFeignClientImpl.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jobpost/applications/{id}/verifyByManager")
    public ResponseEntity<ResponseDto> verifyApplicationByManager(@PathVariable Long id) {
        ResponseDto responseDto = applicationFeignClientImpl.verifyApplicationByManager(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/jobpost/applications/{id}/verifyByManagerRejected")
    public ResponseEntity<ResponseDto> verifyApplicationByManagerRejected(@PathVariable Long id) {
        ResponseDto responseDto = applicationFeignClientImpl.verifyApplicationByManagerRejected(id);
        return ResponseEntity.ok(responseDto);
    }


}
