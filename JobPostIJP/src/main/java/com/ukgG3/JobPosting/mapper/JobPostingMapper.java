package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.entity.Location;
import com.ukgG3.JobPosting.repository.CodingLanguageRepository;
import com.ukgG3.JobPosting.repository.LocationRepository;

import java.util.Optional;
import java.util.stream.Collectors;


public class JobPostingMapper {

    public static JobPostingDto mapToJobPostingDto(JobPosting jobPosting) {
        JobPostingDto dto = new JobPostingDto();
        dto.setJobPosId(jobPosting.getJobPosId());
        dto.setDescription(jobPosting.getDescription());
        dto.setMinExp(jobPosting.getMinExp());
        dto.setMinSal(jobPosting.getMinSal());
        dto.setMaxSal(jobPosting.getMaxSal());
        dto.setIsActive(jobPosting.getIsActive());
        dto.setDesignation(jobPosting.getDesignation());
        dto.setCreatedBy(jobPosting.getCreatedBy());
        dto.setDeadline(jobPosting.getDeadline());
        dto.setLocations(jobPosting.getLocations().stream()
                .map(Location::getLocationId)
                .collect(Collectors.toList()));
        dto.setCodingLanguages(jobPosting.getCodingLanguages().stream()
                .map(CodingLanguage::getLanguageId)
                .collect(Collectors.toList()));

        return dto;
    }

    public static JobPosting mapToJobPosting(JobPostingDto dto, LocationRepository locationRepository, CodingLanguageRepository codingLanguageRepository) {
        JobPosting jobPosting = new JobPosting();
        jobPosting.setDescription(dto.getDescription());
        jobPosting.setMinExp(dto.getMinExp());
        jobPosting.setMinSal(dto.getMinSal());
        jobPosting.setMaxSal(dto.getMaxSal());
        jobPosting.setIsActive(dto.getIsActive());
        jobPosting.setDesignation(dto.getDesignation());
        jobPosting.setCreatedBy(dto.getCreatedBy());
        jobPosting.setDeadline(dto.getDeadline());
        jobPosting.setLocations(dto.getLocations().stream()
                .map(locationRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet()));
        jobPosting.setCodingLanguages(dto.getCodingLanguages().stream()
                .map(codingLanguageRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet()));
        return jobPosting;
    }
}
