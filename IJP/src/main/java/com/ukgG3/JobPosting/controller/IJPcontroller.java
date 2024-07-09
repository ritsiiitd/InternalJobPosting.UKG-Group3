package com.ukgG3.JobPosting.controller;

import com.ukgG3.JobPosting.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IJPcontroller {

    private final IAccountsService iAccountsService;

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }
}
