package com.ukgG3.JobPosting.service.impl;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.mapper.JobPostingMapper;
import com.ukgG3.JobPosting.repository.JobPostingRepository;
import com.ukgG3.JobPosting.service.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class JobPostingServiceImpl implements IJobPostingService {
   @Autowired
    private JobPostingRepository jobPostingRepository;
    @Override
    public void postApplication(JobPostingDto jobPostingDto) {
        JobPosting jobPosting = JobPostingMapper.mapToJobPosting(jobPostingDto, new JobPosting());
//        customer.setCreatedAt(LocalDateTime.now());
//        jobPosting.setCreatedBy("himanshi");
//        jobPosting.setDesignation(LocalDateTime);
        jobPostingRepository.save(jobPosting);
    }
}
