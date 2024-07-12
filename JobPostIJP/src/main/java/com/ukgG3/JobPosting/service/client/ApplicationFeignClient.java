package com.ukgG3.JobPosting.service.client;


import com.ukgG3.JobPosting.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "applicationijp", url = "http://localhost:8081") // Replace with the actual URL of your ApplicationIJP service
@FeignClient(name = "application")
public interface ApplicationFeignClient {
    @GetMapping("/api/applications")
    List<ApplicationDto> getAllApplications();

    @PostMapping("/api/applications/createApplication")
    ResponseDto createApplication(@RequestBody ApplicationDto applicationDto);

    @GetMapping("/api/applications/{id}")
    ApplicationDto getApplicationById(@PathVariable("id") Long id);

    @DeleteMapping("/api/applications/{id}")
    void deleteApplication(@PathVariable("id") Long id);

    @PutMapping("/api/applications/{id}/verifyByManager")
    ResponseDto verifyApplicationByManager(@PathVariable("id") Long id);

    @PutMapping("/api/applications/{id}/verifyByManagerRejected")
    ResponseDto verifyApplicationByManagerRejected(@PathVariable("id") Long id);

    @GetMapping("/api/applications/hello")
    String helloWorld();
}
