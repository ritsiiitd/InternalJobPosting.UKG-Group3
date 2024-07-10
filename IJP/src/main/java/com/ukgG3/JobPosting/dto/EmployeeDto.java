package com.ukgG3.JobPosting.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class EmployeeDto {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate dob;
    private String role;
}
