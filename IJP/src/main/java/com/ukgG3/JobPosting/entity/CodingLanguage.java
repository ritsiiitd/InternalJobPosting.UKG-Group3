package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coding_language")
public class CodingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageId;
    private String langName;
    private String skill;
    // getters and setters
}

