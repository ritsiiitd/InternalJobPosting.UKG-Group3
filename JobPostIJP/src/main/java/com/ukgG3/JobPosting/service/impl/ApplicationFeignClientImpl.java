package com.ukgG3.JobPosting.service.impl;

import com.ukgG3.JobPosting.dto.ApplicationDetailsDto;
import com.ukgG3.JobPosting.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
//import com.ukgG3.JobPosting.entity.ApplicationsDetails;
import com.ukgG3.JobPosting.entity.Employee;
import com.ukgG3.JobPosting.entity.JobPosting;
//import com.ukgG3.JobPosting.mapper.ApplicationsDetailsMapper;
import com.ukgG3.JobPosting.repository.EmployeeRepository;
import com.ukgG3.JobPosting.repository.JobPostingRepository;
import com.ukgG3.JobPosting.service.IApplicationsDetails;
import com.ukgG3.JobPosting.service.client.ApplicationFeignClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




@Service
@AllArgsConstructor
public class ApplicationFeignClientImpl implements IApplicationsDetails {

    private final ApplicationFeignClient applicationFeignClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Override
    public ResponseDto createApplication(ApplicationDto applicationDto) {
        return applicationFeignClient.createApplication(applicationDto);
    }
    @Override
    public ApplicationDto getApplicationById(Long id) {
        System.out.println("2nd");
        return applicationFeignClient.getApplicationById(id);
    }

    @Override
    public List<ApplicationDto> getAllApplications() {
        return applicationFeignClient.getAllApplications();
    }

    @Override
    public void deleteApplication(Long id) {
        applicationFeignClient.deleteApplication(id);
    }
//
    @Override
    public ResponseDto verifyApplicationByManager(Long id) {

        return applicationFeignClient.verifyApplicationByManager(id);
    }
    @Override
    public ResponseDto verifyApplicationByManagerRejected(Long id) {
        return applicationFeignClient.verifyApplicationByManagerRejected(id);
    }

    @Override
    public List<ApplicationDetailsDto> getAllApplicationsDetails() {
        List<ApplicationDto>  applicationDtos=applicationFeignClient.getAllApplications();
        List<ApplicationDetailsDto> applicationsDetailsDtos = new ArrayList<>();

        for (ApplicationDto applicationDto : applicationDtos) {
            Employee employee = employeeRepository.findById(applicationDto.getEmployee_id()).orElse(null);
            JobPosting jobPosting = jobPostingRepository.findById(applicationDto.getJob_pos_id()).orElse(null);

            ApplicationDetailsDto aDetails = new ApplicationDetailsDto();
            if (employee != null) {

                aDetails.setFirst_name(employee.getFirstName());
                aDetails.setLast_name(employee.getLastName());
                aDetails.setEmail(employee.getEmail());
                aDetails.setPassword(employee.getPassword());

            }
            if (jobPosting != null) {
                aDetails.setJob_pos_id(jobPosting.getJobPosId());
                aDetails.setDesignation(jobPosting.getDesignation());

            }
            aDetails.setApp_id(applicationDto.getApp_id());
            aDetails.setEmployee_id(applicationDto.getEmployee_id());
            aDetails.setVerified_by_manager(applicationDto.isVerified_by_manager());
            aDetails.setStatus(applicationDto.getStatus());

            applicationsDetailsDtos.add(aDetails);
        }


        return applicationsDetailsDtos;

    }

    @Override
    public List<ApplicationDetailsDto> getAllApplicationsDetailsManager(Long mgId) {
        List<ApplicationDto>  applicationDtos=applicationFeignClient.getAllApplications();
        List<ApplicationDetailsDto> applicationsDetailsDtos = new ArrayList<>();

        for (ApplicationDto applicationDto : applicationDtos) {
            Employee employee = employeeRepository.findById(applicationDto.getEmployee_id()).orElse(null);
            JobPosting jobPosting = jobPostingRepository.findById(applicationDto.getJob_pos_id()).orElse(null);





                if (employee != null && employee.getReportsTo() != null && employee.getReportsTo() == mgId.intValue()) {
                ApplicationDetailsDto aDetails = new ApplicationDetailsDto();
                if (employee != null) {

                    aDetails.setFirst_name(employee.getFirstName());
                    aDetails.setLast_name(employee.getLastName());
                    aDetails.setEmail(employee.getEmail());
                    aDetails.setPassword(employee.getPassword());

                }
                if (jobPosting != null) {
                    aDetails.setJob_pos_id(jobPosting.getJobPosId());
                    aDetails.setDesignation(jobPosting.getDesignation());

                }
                aDetails.setApp_id(applicationDto.getApp_id());
                aDetails.setEmployee_id(applicationDto.getEmployee_id());
                aDetails.setVerified_by_manager(applicationDto.isVerified_by_manager());
                aDetails.setStatus(applicationDto.getStatus());


                applicationsDetailsDtos.add(aDetails);


            }
        }


        return applicationsDetailsDtos;

    }
}


