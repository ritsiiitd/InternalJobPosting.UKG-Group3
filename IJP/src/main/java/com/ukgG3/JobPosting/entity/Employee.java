package com.ukgG3.JobPosting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    public enum Role{
        EMPLOYEE,
        HR,
        MANAGER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role eRole;

//    @ManyToOne
//    @JoinColumn(name = "reports_to")
    private String reportsTo;


}

