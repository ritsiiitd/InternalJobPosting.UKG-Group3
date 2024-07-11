package com.ukgG3.JobPosting.dto;

import java.time.LocalDate;

public class ApplicationDetailsDto {
    private Long employee_id;
    private Long app_id;
    private Long job_pos_id;
    private boolean verified_by_manager; // Maybe not in entity but needed for DTO
    private String status;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate dob;
    private String role;
}
