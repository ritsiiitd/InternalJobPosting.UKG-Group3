package com.ukgG3.JobPosting.dto;

import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.Location;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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