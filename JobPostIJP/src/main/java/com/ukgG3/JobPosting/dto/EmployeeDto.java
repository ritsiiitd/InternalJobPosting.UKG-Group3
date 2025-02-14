package com.ukgG3.JobPosting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EmployeeDto {
    private long employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate dob;
    private String role;
}
