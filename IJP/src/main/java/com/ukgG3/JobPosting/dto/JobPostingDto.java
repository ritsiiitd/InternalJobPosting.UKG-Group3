package com.ukgG3.JobPosting.dto;

import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.Location;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Data
public class JobPostingDto {
    private String description;
    private Integer minExp;
    private Integer minSal;
    private Integer maxSal;
    private Boolean isActive;
    private String designation;
    private Long createdBy;
    private LocalDate deadline;
//    private Location location;
    private List<Location> locations;
    private List<CodingLanguage> codingLanguages;
}
