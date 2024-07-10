package com.ukgG3.Application.controller;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.service.IApplicationService;
import com.ukgG3.JobPosting.Dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class ApplicationController {
    private final IApplicationService iApplicationService;

    @PostMapping("/createApplication")
    public ResponseEntity<ResponseDto> createApplication( @RequestBody ApplicationDto applicationDto) {
        iApplicationService.createApplication(applicationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Application created successfully"));
    }


}
