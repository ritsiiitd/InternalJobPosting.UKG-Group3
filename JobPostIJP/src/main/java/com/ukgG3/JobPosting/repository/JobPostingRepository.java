package com.ukgG3.JobPosting.repository;

import com.ukgG3.JobPosting.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long>{
}
