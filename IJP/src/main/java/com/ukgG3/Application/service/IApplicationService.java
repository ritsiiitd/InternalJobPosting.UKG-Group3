package com.ukgG3.Application.service;

import com.ukgG3.Application.Dto.ApplicationDto;
import com.ukgG3.JobPosting.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



public interface IApplicationService  {

    void createApplication(ApplicationDto applicationDto);


}
