package com.ukgG3.JobPosting.repository;

import com.ukgG3.JobPosting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
