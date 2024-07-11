package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.JobPosting;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JobPostingMapper {

    public static JobPosting mapToJobPosting(JobPostingDto jobPostingDto, JobPosting jobPosting) {
//        JobPosting entity = new JobPosting();
//        jobPosting.setJobPosId(jobPostingDto.getJobPosId());
        jobPosting.setDescription(jobPostingDto.getDescription());
        jobPosting.setMinExp(jobPostingDto.getMinExp());
        jobPosting.setMinSal(jobPostingDto.getMinSal());
        jobPosting.setMaxSal(jobPostingDto.getMaxSal());
        jobPosting.setIsActive(jobPostingDto.getIsActive());
        jobPosting.setDesignation(jobPostingDto.getDesignation());
        jobPosting.setCreatedBy(jobPostingDto.getCreatedBy());
        jobPosting.setDeadline(jobPostingDto.getDeadline());
//        jobPosting.setLocation(jobPostingDto.getLocation());
        jobPosting.setLocations(jobPostingDto.getLocations());
        jobPosting.setCodingLanguages(jobPostingDto.getCodingLanguages());
        return jobPosting;
    }
    public static JobPostingDto mapToJobPostingDto(JobPostingDto jobPostingDto, JobPosting jobPosting){
//        jobPostingDto.setJobPosId(jobPosting.getJobPosId());
        jobPostingDto.setDescription(jobPosting.getDescription());
        jobPostingDto.setMinExp(jobPosting.getMinExp());
        jobPostingDto.setMinSal(jobPosting.getMinSal());
        jobPostingDto.setMaxSal(jobPosting.getMaxSal());
        jobPostingDto.setIsActive(jobPosting.getIsActive());
        jobPostingDto.setDesignation(jobPosting.getDesignation());
        jobPostingDto.setCreatedBy(jobPosting.getCreatedBy());
        jobPostingDto.setDeadline(jobPosting.getDeadline());
//        jobPostingDto.setLocation(jobPosting.getLocation());
        jobPostingDto.setLocations(jobPosting.getLocations());
        jobPostingDto.setCodingLanguages(jobPosting.getCodingLanguages());
        return jobPostingDto;
    }
}

