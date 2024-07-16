package com.ukgG3.Application.mapper;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.entity.Application;

public class ApplicationMapper {


    public static ApplicationDto mapToApplicationDto(Application application, ApplicationDto applicationDto) {
        applicationDto.setEmployee_id(application.getEmployeeId());
        applicationDto.setJob_pos_id(application.getJobPosId());
        applicationDto.setVerified_by_manager(application.isVerifiedByManager());
        applicationDto.setStatus(application.getStatus());
        applicationDto.setApp_id(application.getApplicationId());
        return applicationDto;
    }

    public static Application mapToApplication(ApplicationDto applicationDto, Application application) {
        application.setEmployeeId(applicationDto.getEmployee_id());
        application.setJobPosId(applicationDto.getJob_pos_id());
        application.setVerifiedByManager(applicationDto.isVerified_by_manager());
        application.setStatus(applicationDto.getStatus());
        application.setApplicationId(applicationDto.getApp_id());
        return application;
    }
}
