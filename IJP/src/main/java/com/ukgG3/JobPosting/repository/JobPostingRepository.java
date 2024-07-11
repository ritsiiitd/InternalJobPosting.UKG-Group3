package com.ukgG3.JobPosting.repository;

import com.ukgG3.JobPosting.entity.JobPosting;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan(basePackages = "com.ukgG3.JobPosting")
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
