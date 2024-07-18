package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.dto.JobPostingGetAllDto;
import com.ukgG3.JobPosting.entity.CodingLanguage;
import com.ukgG3.JobPosting.entity.JobPosting;
import com.ukgG3.JobPosting.entity.Location;

import java.util.List;
import java.util.stream.Collectors;

public class JobPostingGetAllMapper {
    public static JobPostingGetAllDto mapToJobPostingGetAllDto(JobPosting jobPosting){
        JobPostingGetAllDto dto=new JobPostingGetAllDto();
        dto.setJobPosId(jobPosting.getJobPosId());
        dto.setDescription(jobPosting.getDescription());
        dto.setMinExp(jobPosting.getMinExp());
        dto.setMinSal(jobPosting.getMinSal());
        dto.setMaxSal(jobPosting.getMaxSal());
        dto.setIsActive(jobPosting.getIsActive());
        dto.setDesignation(jobPosting.getDesignation());
        dto.setCreatedBy(jobPosting.getCreatedBy());
        dto.setDeadline(jobPosting.getDeadline());
        List<String> locationNames = jobPosting.getLocations().stream()
                .map(Location::getName)
                .collect(Collectors.toList());
        dto.setLocations(locationNames);

        // Mapping coding language names
        List<String> codingLanguageNames = jobPosting.getCodingLanguages().stream()
                .map(CodingLanguage::getLangName)
                .collect(Collectors.toList());
        dto.setCodingLanguages(codingLanguageNames);

        return dto;
    }
}

