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
public class ApplicationController {
    private final IApplicationService iApplicationService;

    @GetMapping
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
        return ResponseEntity.ok(new ResponseDto("200", "Application verified by manager successfully"));
    }

}
