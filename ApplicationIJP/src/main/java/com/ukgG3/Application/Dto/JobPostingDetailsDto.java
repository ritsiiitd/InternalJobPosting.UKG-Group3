package com.ukgG3.Application.Dto;

import java.util.List;

public class JobPostingDetailsDto {

    private Long jobPosId;
    private String description;
    private Integer minExp;
    private Boolean isActive;
    private String designation;
    private Long createdBy;
    private List<Long> locations;
    private List<Long> codingLanguages;
    private EmployeeDto employeeDto;
    private JobPostingDto jobPostingDto;
}
