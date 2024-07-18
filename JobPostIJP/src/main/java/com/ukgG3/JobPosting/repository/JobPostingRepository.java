package com.ukgG3.JobPosting.repository;

import com.ukgG3.JobPosting.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long>{
    @Query("SELECT jp FROM JobPosting jp JOIN FETCH jp.locations JOIN FETCH jp.codingLanguages")
    List<JobPosting> findAllWithLocationsAndCodingLanguages();
}
