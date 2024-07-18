package com.ukgG3.Application.service;

import com.ukgG3.Application.Dto.ApplicationDto;

import java.util.List;


public interface IApplicationService  {

    void createApplication(ApplicationDto applicationDto);
    List<ApplicationDto> getAllApplications();
    ApplicationDto getApplicationById(Long id);
    void deleteApplication(Long id);
    void verifyApplicationByManagerAccepted(Long id);
    void verifyApplicationByManagerRejected(Long id);

    List<ApplicationDto> getApplicationsByEmployeeId(Long employee_id);

    List<ApplicationDto> getApplicationsByJobId(Long jobId);
}
