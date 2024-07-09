package com.ukgG3.JobPosting.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Data @AllArgsConstructor @NoArgsConstructor
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAtz;
    private String updatedBy;
    private String createdBy;
}
