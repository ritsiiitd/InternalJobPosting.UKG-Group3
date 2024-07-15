package com.ukgG3.JobPosting.service;

import com.ukgG3.JobPosting.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IApplicationsDetails {
    //    void getApplications();
    ApplicationDto getApplicationById( Long id);
    List<ApplicationDto> getAllApplications();

    ResponseDto createApplication(ApplicationDto applicationDto);
    void deleteApplication(Long id);
    ResponseDto verifyApplicationByManager(Long id);
    ResponseDto verifyApplicationByManagerRejected(Long id);


}
