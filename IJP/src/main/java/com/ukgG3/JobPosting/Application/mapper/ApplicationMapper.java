package com.ukgG3.JobPosting.Application.mapper;


import com.ukgG3.JobPosting.Application.dto.ApplicationDTO;
import com.ukgG3.JobPosting.Application.entity.Application;


public class ApplicationMapper {
    public static ApplicationDTO mapToApplicationDto(Application application, ApplicationDTO applicationDTO){
        applicationDTO.setEmployeeId(application.getEmployeeId());
        applicationDTO.setJobPosId(application.getJobPosId());
        applicationDTO.setStatus(application.isStatus());
        applicationDTO.setVerifiedByManager(application.isVerifiedByManager());
        return applicationDTO;
    }

    public static Application mapToApplication(ApplicationDTO applicationDTO, Application application){
        application.setEmployeeId(applicationDTO.getEmployeeId());
        application.setJobPosId(applicationDTO.getJobPosId());
        application.setStatus(applicationDTO.isStatus());
        application.setVerifiedByManager(applicationDTO.isVerifiedByManager());
        return application;
    }
}
