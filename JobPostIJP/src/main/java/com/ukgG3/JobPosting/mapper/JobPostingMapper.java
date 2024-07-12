package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.entity.Location;

import java.util.stream.Collectors;

public class JobPostingMapper {

    public static JobPostingDto mapToJobPostingDto(JobPosting jobPosting, JobPostingDto jobPostingDto) {

        jobPostingDto.setDescription(jobPosting.getDescription());
        jobPostingDto.setMinExp(jobPosting.getMinExp());
        jobPostingDto.setMinSal(jobPosting.getMinSal());
        jobPostingDto.setMaxSal(jobPosting.getMaxSal());
        jobPostingDto.setIsActive(jobPosting.getIsActive());
        jobPostingDto.setDesignation(jobPosting.getDesignation());
        jobPostingDto.setCreatedBy(jobPosting.getCreatedBy());
        jobPostingDto.setDeadline(jobPosting.getDeadline());
        // Convert Set<Location> to List<Integer>
        jobPostingDto.setLocations(jobPosting.getLocations().stream()
                .map(Location::getLocationId)
                .collect(Collectors.toList()));

        // Convert Set<CodingLanguage> to List<Integer>
        jobPostingDto.setCodingLanguages(jobPosting.getCodingLanguages().stream()
                .map(CodingLanguage::getLanguageId)
                .collect(Collectors.toList()));
        return jobPostingDto;
    }

    public static JobPosting mapToJobPosting(JobPostingDto jobPostingDto, JobPosting jobPosting) {

        jobPosting.setDescription(jobPostingDto.getDescription());
        jobPosting.setMinExp(jobPostingDto.getMinExp());
        jobPosting.setMinSal(jobPostingDto.getMinSal());
        jobPosting.setMaxSal(jobPostingDto.getMaxSal());
        jobPosting.setIsActive(jobPostingDto.getIsActive());
        jobPosting.setDesignation(jobPostingDto.getDesignation());
        jobPosting.setCreatedBy(jobPostingDto.getCreatedBy());
        jobPosting.setDeadline(jobPostingDto.getDeadline());
        jobPosting.setLocations(jobPostingDto.getLocations().stream()
                .map(locationId -> new Location()) // Simplified for demonstration; replace with actual fetch logic
                .collect(Collectors.toSet()));

        jobPosting.setCodingLanguages(jobPostingDto.getCodingLanguages().stream()
                .map(codingLanguageId -> new CodingLanguage(codingLanguageId)) // Simplified; replace with actual fetch logic
                .collect(Collectors.toSet()));
        return jobPosting;
    }

}



