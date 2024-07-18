package com.ukgG3.JobPosting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


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
    private String designation;
}
