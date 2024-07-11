package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "jobPosting")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Location> locations;

    @OneToMany
    @JoinTable(
            name = "coding_language",
            joinColumns = @JoinColumn(name = "jobPosId"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<CodingLanguage> codingLanguages;

//    public JobPosting() {
//
//    }
}
