package com.ukgG3.JobPosting.service.impl;

// JobPostingServiceImpl.jav
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.mapper.JobPostingMapper;
import com.ukgG3.JobPosting.repository.CodingLanguageRepository;
import com.ukgG3.JobPosting.repository.JobPostingRepository;
import com.ukgG3.JobPosting.repository.LocationRepository;
import com.ukgG3.JobPosting.service.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobPostingServiceImpl implements IJobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CodingLanguageRepository codingLanguageRepository;

    @Override
    public List<JobPostingDto> getAllJobPostings() {
        return jobPostingRepository.findAll().stream()
                .map(JobPostingMapper::mapToJobPostingDto)
                .collect(Collectors.toList());
    }

    @Override
    public JobPostingDto getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .map(JobPostingMapper::mapToJobPostingDto)
                .orElse(null);
    }

    @Override
    public boolean saveJobPosting(JobPostingDto dto) {
        JobPosting jobPosting = JobPostingMapper.mapToJobPosting(dto, locationRepository, codingLanguageRepository);
        jobPostingRepository.save(jobPosting);
        return true;
    }

    @Override
    public void deleteJobPosting(Long id) {
        if (jobPostingRepository.existsById(id)) {
            jobPostingRepository.deleteById(id);
        }
    }

    @Override
    public boolean updateIsActive(Long id, Boolean isActive) {
        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(id);
        if (jobPostingOptional.isPresent()) {
            JobPosting jobPosting = jobPostingOptional.get();
            jobPosting.setIsActive(false);
            jobPostingRepository.save(jobPosting);
            return true;
        } else {
            return false;
        }
    }

}
