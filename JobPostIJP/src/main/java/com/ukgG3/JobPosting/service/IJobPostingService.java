package com.ukgG3.JobPosting.service;

import com.ukgG3.JobPosting.dto.CodingLanguageDto;
import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.dto.LocationDto;

import java.util.List;

public interface IJobPostingService {
    List<JobPostingDto> getAllJobPostings();
    JobPostingDto getJobPostingById(Long id);
    JobPostingDto saveJobPosting(JobPostingDto jobPostingDTO);
    void deleteJobPosting(Long id);
    List<LocationDto> getAllLocations();
    List<CodingLanguageDto> getAllCodingLang();
    boolean updateIsActive(Long id, Boolean isActive);
}
