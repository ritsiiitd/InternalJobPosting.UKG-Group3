package com.ukgG3.JobPosting.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dob;
    private String role;
}
