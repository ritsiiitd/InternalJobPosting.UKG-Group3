package com.ukgG3.JobPosting.service;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import org.springframework.stereotype.Service;

@Service
public interface IJobPostingService {
    void postApplication(JobPostingDto jobPostingDto);
}
