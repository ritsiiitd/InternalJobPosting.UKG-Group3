package com.ukgG3.Application.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class ApplicationDto {
    
//    private Long applicationId;
    private Long employee_id;
    private Long app_id;
    private Long job_pos_id;
    private boolean verified_by_manager; // Maybe not in entity but needed for DTO
    private String status;

}
