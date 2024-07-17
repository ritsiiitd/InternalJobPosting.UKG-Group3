package com.ukgG3.JobPosting.repository;

import com.ukgG3.JobPosting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByreportsTo(Long mgId );

}
