package com.ukgG3.JobPosting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CodingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String langName;
    private String skill;
    // getters and setters
}

