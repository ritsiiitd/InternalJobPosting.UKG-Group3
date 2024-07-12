package com.ukgG3.JobPosting.service.impl;

import com.ukgG3.JobPosting.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import com.ukgG3.JobPosting.service.client.ApplicationFeignClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFeignClientImpl implements ApplicationFeignClient {

    private final ApplicationFeignClient applicationFeignClient;

    @Autowired
    public ApplicationFeignClientImpl(ApplicationFeignClient applicationFeignClient) {
        this.applicationFeignClient = applicationFeignClient;
    }

    public List<ApplicationDto> getAllApplications() {
        return applicationFeignClient.getAllApplications();
    }

    public ResponseDto createApplication(ApplicationDto applicationDto) {
        return applicationFeignClient.createApplication(applicationDto);
    }

    public ApplicationDto getApplicationById(Long id) {
        return applicationFeignClient.getApplicationById(id);
    }

    public void deleteApplication(Long id) {
        applicationFeignClient.deleteApplication(id);
    }

    public ResponseDto verifyApplicationByManager(Long id) {
        return applicationFeignClient.verifyApplicationByManager(id);
    }

    public ResponseDto verifyApplicationByManagerRejected(Long id) {
        return applicationFeignClient.verifyApplicationByManagerRejected(id);
    }

    public String helloWorld() {
        return applicationFeignClient.helloWorld();
    }
}
