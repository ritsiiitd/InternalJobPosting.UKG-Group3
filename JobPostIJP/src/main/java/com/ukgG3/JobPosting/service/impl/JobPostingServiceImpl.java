package com.ukgG3.JobPosting.service.impl;

// JobPostingServiceImpl.jav
import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.Location;
import com.ukgG3.JobPosting.mapper.EmployeeMapper;
import com.ukgG3.JobPosting.mapper.JobPostingMapper;
import com.ukgG3.JobPosting.repository.JobPostingRepository;
import com.ukgG3.JobPosting.repository.LocationRepository;
import com.ukgG3.JobPosting.service.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobPostingServiceImpl implements IJobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationRepository codingLanguageRepository;


    @Override
    public List<JobPostingDto> getAllJobPostings() {
        return jobPostingRepository.findAll().stream()
                .map(jobPosting -> {
                    return JobPostingMapper.mapToJobPostingDto(jobPosting, new JobPostingDto());
                })
                .collect(Collectors.toList());
    }

    @Override
    public JobPostingDto getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .map(jobPosting -> {
                    return JobPostingMapper.mapToJobPostingDto(jobPosting, new JobPostingDto());
                })
                .orElse(null);
    }


    @Override
    public boolean saveJobPosting(JobPostingDto jobPostingDTO) {
        JobPosting jobPosting = JobPostingMapper.mapToJobPosting(jobPostingDTO, new JobPosting());
        Set<Location> locations = locationRepository.findAllById(jobPostingDTO.getLocations());
        Set<CodingLanguage> codingLanguages = codingLanguageRepository.findAllById(jobPostingDTO.getCodingLanguages());
        jobPosting.setLocations(locations);
        jobPosting.setCodingLanguages(codingLanguages);
        jobPostingRepository.save(jobPosting);
        return true;
    }

    @Override
    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }
}
