package com.ukgG3.JobPosting.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class JobPostingDto {
    private Long jobPosId;
    private String description;
    private Integer minExp;
    private Integer minSal;
    private Integer maxSal;
    private Boolean isActive;
    private String designation;
    private Long createdBy;
    private LocalDate deadline;
    private List<Long> locations;
    private List<Long> codingLanguages;
}