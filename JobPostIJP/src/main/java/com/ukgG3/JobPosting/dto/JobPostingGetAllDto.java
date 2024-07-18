package com.ukgG3.JobPosting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobPostingGetAllDto {
    private Long jobPosId;
    private String description;
    private Integer minExp;
    private Integer minSal;
    private Integer maxSal;
    private Boolean isActive;
    private String designation;
    private Long createdBy;
    private LocalDate deadline;
    private List<String> locations;
    private List<String> codingLanguages;
}
