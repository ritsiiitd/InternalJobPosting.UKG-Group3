package com.ukgG3.JobPosting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodingLanguage {

    public CodingLanguage(Long languageId) {
        this.languageId = languageId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String langName;
    private String skill;
    // getters and setters
}

