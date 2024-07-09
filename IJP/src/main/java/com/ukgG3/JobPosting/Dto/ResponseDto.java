package com.ukgG3.JobPosting.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private HttpStatus statusCode;
    private String responseMessage;
}
