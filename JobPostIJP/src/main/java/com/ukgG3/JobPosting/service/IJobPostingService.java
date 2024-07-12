package com.ukgG3.JobPosting.service;

import com.ukgG3.JobPosting.dto.JobPostingDto;

import java.util.List;

public interface IJobPostingService {
    List<JobPostingDto> getAllJobPostings();
    JobPostingDto getJobPostingById(Long id);
    boolean saveJobPosting(JobPostingDto jobPostingDTO);
    void deleteJobPosting(Long id);
}
