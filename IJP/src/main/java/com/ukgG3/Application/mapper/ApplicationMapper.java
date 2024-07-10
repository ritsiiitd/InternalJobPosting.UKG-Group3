package com.ukgG3.Application.mapper;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.entity.Application;

public class ApplicationMapper {


    public static ApplicationDto mapToApplicationDto(Application application, ApplicationDto applicationDto) {
        applicationDto.setEmployee_id(application.getEmployee_id());
        applicationDto.setJob_pos_id(application.getJob_pos_id());
        applicationDto.setVerified_by_manager(application.isVerified_by_manager());
        applicationDto.setStatus(application.getStatus());
        return applicationDto;
    }

    public static Application mapToApplication(ApplicationDto applicationDto, Application application) {
        application.setEmployee_id(applicationDto.getEmployee_id());
        application.setJob_pos_id(applicationDto.getJob_pos_id());
        application.setVerified_by_manager(applicationDto.isVerified_by_manager());
        application.setStatus(applicationDto.getStatus());
        return application;
    }
}
