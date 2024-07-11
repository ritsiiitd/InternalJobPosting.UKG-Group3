package com.ukgG3.JobPosting.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class GetApplicationController {
    @GetMapping("/getApplications")
        public ResponseEntity<String> getApplications(){
            return ResponseEntity.status(HttpStatus.OK).body("Applications");
    }
}
