package com.ukgG3.JobPosting.controller;


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
public class GetApplicationController {
    private final ApplicationFeignClientImpl applicationFeignClientImpl;
//    @GetMapping("/getApplications")
//        public ResponseEntity<String> getApplications(){
//            return ResponseEntity.status(HttpStatus.OK).body("Applications");
//    }

    @GetMapping("/applications")
    public List<ApplicationDto> getAllApplications() {
        return applicationFeignClientImpl.getAllApplications();
    }

    @PostMapping("/createapplications")
    public ResponseEntity<ResponseDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        ResponseDto responseDto = applicationFeignClientImpl.createApplication(applicationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
        ApplicationDto applicationDto = applicationFeignClientImpl.getApplicationById(id);
        return ResponseEntity.ok(applicationDto);
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationFeignClientImpl.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/applications/{id}/verifyByManager")
    public ResponseEntity<ResponseDto> verifyApplicationByManager(@PathVariable Long id) {
        ResponseDto responseDto = applicationFeignClientImpl.verifyApplicationByManager(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/applications/{id}/verifyByManagerRejected")
    public ResponseEntity<ResponseDto> verifyApplicationByManagerRejected(@PathVariable Long id) {
        ResponseDto responseDto = applicationFeignClientImpl.verifyApplicationByManagerRejected(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/applications/hello")
    public ResponseEntity<String> helloWorld() {
        String message = applicationFeignClientImpl.helloWorld();
        return ResponseEntity.ok(message);
    }
}
