package com.ukgG3.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id") // Use the actual column name from schema
    private Long app_id;

    @Column(name = "employee_id") // Use the actual column name from schema
    private Long employee_id;

    @Column(name = "job_pos_id") // Use the actual column name from schema
    private Long job_pos_id;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApplicationStatus status;


//    @Column(name = "applied_at")
//    private LocalDateTime appliedAt; // Assuming applied_at is a timestamp

    @Column(name = "verified_by_manager")
    private boolean verified_by_manager;


}
