package com.ukgG3.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private Long applicationId;

    @Column(name = "employee_id") // Use the actual column name from schema
    private Long employeeId;

    @Column(name = "job_pos_id") // Use the actual column name from schema
    private Long jobPosId;



    @Column(name = "status")
    private String status;


//    @Column(name = "applied_at")
//    private LocalDateTime appliedAt; // Assuming applied_at is a timestamp

    @Column(name = "verified_by_manager")
    private boolean verifiedByManager;


}
