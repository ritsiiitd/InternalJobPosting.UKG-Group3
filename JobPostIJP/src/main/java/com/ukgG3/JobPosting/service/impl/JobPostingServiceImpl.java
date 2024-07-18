package com.ukgG3.JobPosting.service.impl;

// JobPostingServiceImpl.jav
import com.ukgG3.JobPosting.dto.CodingLanguageDto;
import com.ukgG3.JobPosting.dto.JobPostingGetAllDto;
import com.ukgG3.JobPosting.dto.LocationDto;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.mapper.CodingLanguageMapper;
import com.ukgG3.JobPosting.mapper.JobPostingGetAllMapper;
import com.ukgG3.JobPosting.mapper.JobPostingMapper;
import com.ukgG3.JobPosting.mapper.LocationMapper;
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
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locations ->
                {
                    LocationDto locationDto=LocationMapper.mapToLocationDto(locations, new LocationDto());
                    locationDto.setLocationId(locations.getLocationId());
                    return locationDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CodingLanguageDto> getAllCodingLang() {
        return codingLanguageRepository.findAll().stream()
                .map(codingLanguage ->
                {
                    CodingLanguageDto codingLanguageDto=CodingLanguageMapper.mapToCodingLanguageDto(codingLanguage, new CodingLanguageDto());
                    codingLanguageDto.setLanguageId(codingLanguage.getLanguageId());
                    return codingLanguageDto;

                })
                .collect(Collectors.toList());
    }

    @Override
    public CodingLanguageDto getCodingLangById(Long id) {
        return codingLanguageRepository.findById(id).map(codingLanguage -> {
            return CodingLanguageMapper.mapToCodingLanguageDto(codingLanguage, new CodingLanguageDto());
        })
                .orElse(null);

    }
    @Override
    public LocationDto getLocationById(Long id) {
        return locationRepository.findById(id).map(location -> {
            return LocationMapper.mapToLocationDto(location, new LocationDto());
        })
                .orElse(null);

    }


    @Override
    public List<JobPostingGetAllDto> getAllJobPostingsAll() {
        return jobPostingRepository.findAllWithLocationsAndCodingLanguages().stream()
                .map(JobPostingGetAllMapper::mapToJobPostingGetAllDto)
                .collect(Collectors.toList());
    }


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
    public JobPostingDto saveJobPosting(JobPostingDto dto) {
        JobPosting jobPosting = JobPostingMapper.mapToJobPosting(dto, locationRepository, codingLanguageRepository);
        jobPostingRepository.save(jobPosting);
        return JobPostingMapper.mapToJobPostingDto(jobPosting);
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
