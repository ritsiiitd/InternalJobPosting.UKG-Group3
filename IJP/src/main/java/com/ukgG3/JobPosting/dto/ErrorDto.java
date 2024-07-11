package com.ukgG3.JobPosting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorDto {
    private String errorMessage;
    private String apiPath;
    private LocalDateTime errorTime;
    private HttpStatus statusCode;
}
