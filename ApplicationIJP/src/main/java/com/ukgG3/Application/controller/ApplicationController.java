package com.ukgG3.Application.controller;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.Dto.ResponseDto;
import com.ukgG3.Application.service.IApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {
    private final IApplicationService iApplicationService;

    @GetMapping("/getAllApplications")
    public List<ApplicationDto> getAllApplications() {
        return iApplicationService.getAllApplications();
    }

    @PostMapping("/createApplication")
    public ResponseEntity<ResponseDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        iApplicationService.createApplication(applicationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Application created successfully"));
    }

    @GetMapping("/{id}")
    public ApplicationDto getApplicationById(@PathVariable Long id) {
        return iApplicationService.getApplicationById(id);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        iApplicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/verifyByManager")
    public ResponseEntity<ResponseDto> verifyApplicationByManager(@PathVariable Long id) {
        iApplicationService.verifyApplicationByManagerAccepted(id);
        return ResponseEntity.ok(new ResponseDto("200", "Application accepted verified by manager successfully"));
    }
    @PutMapping("/{id}/verifyByManagerRejected")
    public ResponseEntity<ResponseDto> verifyApplicationByManagerRejected(@PathVariable Long id) {
        iApplicationService.verifyApplicationByManagerRejected(id);
        return ResponseEntity.ok(new ResponseDto("200", "Application rejection verified by manager successfully"));
    }

    @GetMapping("/byEmployee/{employee_id}")
    public List<ApplicationDto> getApplicationsByEmployeeId(@PathVariable Long employee_id) {
        return iApplicationService.getApplicationsByEmployeeId(employee_id);
    }
    @GetMapping("/job/{jobId}")
    public List<ApplicationDto> getApplicationsByJobId(@PathVariable Long jobId) {
        return iApplicationService.getApplicationsByJobId(jobId);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World this is application service!");
    }

}
