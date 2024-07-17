package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
}

