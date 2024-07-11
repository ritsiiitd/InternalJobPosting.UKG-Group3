package com.ukgG3.Application.service;

import com.ukgG3.Application.Dto.ApplicationDto;

import java.util.List;


public interface IApplicationService  {

    void createApplication(ApplicationDto applicationDto);
    List<ApplicationDto> getAllApplications();
    ApplicationDto getApplicationById(Long id);
    void deleteApplication(Long id);

}
