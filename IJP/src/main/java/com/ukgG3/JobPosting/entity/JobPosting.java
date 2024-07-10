package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "location_id")
    private com.ukgG3.JobPosting.entity.Location location;

    @OneToMany
    @JoinTable(
            name = "location_junction",
            joinColumns = @JoinColumn(name = "jobPosId"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations;

    @OneToMany
    @JoinTable(
            name = "coding_language",
            joinColumns = @JoinColumn(name = "jobPosId"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<CodingLanguage> codingLanguages;
}
