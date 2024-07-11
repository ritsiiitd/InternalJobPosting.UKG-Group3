// Location.java
package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String name;
    // getters and setters
}
