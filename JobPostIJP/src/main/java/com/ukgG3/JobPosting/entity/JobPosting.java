package com.ukgG3.JobPosting.entity;

import com.ukgG3.JobPosting.converter.StringtoIntegerConverter;
import com.ukgG3.JobPosting.dto.CodingLanguageDto;
import com.ukgG3.JobPosting.dto.LocationDto;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobPosId;
    private String description;
    private Integer minExp;
    private Integer minSal;
    private Integer maxSal;
    private Boolean isActive;
    private String designation;
    private Long createdBy;
    private LocalDate deadline;

    @ManyToMany
    @JoinTable(
            name = "job_posting_location",
            joinColumns = @JoinColumn(name = "job_posting_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations;

    @ManyToMany
    @JoinTable(
            name = "job_posting_coding_language",
            joinColumns = @JoinColumn(name = "job_posting_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<CodingLanguage> codingLanguages;

}
