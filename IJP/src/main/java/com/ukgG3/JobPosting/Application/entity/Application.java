package com.ukgG3.JobPosting.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "application")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "App_ID")
    private int appId;

    @Column(name = "Employee_ID")
    private int employeeId;

    @Column(name = "JobPos_ID")
    private int jobPosId;

    @Column(name = "status")
    private boolean status;

    @Column(name = "Verified_By_manager")
    private boolean verifiedByManager;

}


