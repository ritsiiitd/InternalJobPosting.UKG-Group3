package com.ukgG3.Application.service.impl;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.entity.Application;
import com.ukgG3.Application.entity.ApplicationStatus;
import com.ukgG3.Application.exception.ResourceNotFoundException;
import com.ukgG3.Application.mapper.ApplicationMapper;
import com.ukgG3.Application.repository.ApplicationRepository;
import com.ukgG3.Application.service.IApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements IApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public void createApplication(ApplicationDto applicationDto) {
        Application application= ApplicationMapper.mapToApplication(applicationDto,new Application());
//        application.setAppliedAt(LocalDateTime.now());
        applicationRepository.save(application);
    }

    @Override
    public List<ApplicationDto> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(application -> {
                    return ApplicationMapper.mapToApplicationDto(application,new ApplicationDto());
                })
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDto getApplicationById(Long id) {
        System.out.println("3rd");
        return applicationRepository.findById(id)
                .map(
                        application -> {
                            ApplicationDto applicationDto = ApplicationMapper.mapToApplicationDto(application,new ApplicationDto());
                            applicationDto.setApp_id(application.getApplicationId());
                            return applicationDto;
                        }
                )
                .orElse(null);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
    @Override
    public void verifyApplicationByManagerAccepted(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application", "id", id.toString()));
        application.setVerifiedByManager(true);
        application.setStatus("ACCEPTED");
        applicationRepository.save(application);
    }

    @Override
    public void verifyApplicationByManagerRejected(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application", "id", id.toString()));
        application.setVerifiedByManager(false);
        application.setStatus("REJECTED");
        applicationRepository.save(application);

    }
}
