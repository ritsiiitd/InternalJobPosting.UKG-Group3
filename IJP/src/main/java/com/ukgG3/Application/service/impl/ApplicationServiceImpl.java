package com.ukgG3.Application.service.impl;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.Application.entity.Application;
import com.ukgG3.Application.mapper.ApplicationMapper;
import com.ukgG3.Application.repository.ApplicationRepository;
import com.ukgG3.Application.service.IApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


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

}
