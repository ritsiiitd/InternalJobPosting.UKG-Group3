//package com.ukgG3.Application.service.impl;
//
//import com.ukgG3.Application.Dto.EmployeeDto;
//import com.ukgG3.Application.Dto.JobPostingDto;
//import com.ukgG3.Application.service.IJobPostingDetails;
//import com.ukgG3.Application.service.client.JobPostingFeignClient;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class JobPostingDetailsServiceImpl implements IJobPostingDetails {
//    private final JobPostingFeignClient jobPostingFeignClient;
//
//
//    public ResponseEntity<JobPostingDto> fetchJobPosting(Long id){
//        return jobPostingFeignClient.getJobPostingById(id);
//    }
//
//    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
//        return jobPostingFeignClient.getEmployeeById(id);
//    }
//}


package com.ukgG3.Application.service.impl;

import com.ukgG3.Application.Dto.EmployeeDto;
import com.ukgG3.Application.Dto.JobPostingDto;
import com.ukgG3.Application.service.IJobPostingDetails;
import com.ukgG3.Application.service.client.JobPostingFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobPostingDetailsServiceImpl implements IJobPostingDetails {
    private final JobPostingFeignClient jobPostingFeignClient;

    @Override
    public ResponseEntity<JobPostingDto> getJobPostingById(Long id) {
        return jobPostingFeignClient.getJobPostingById(id);
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) {
        return jobPostingFeignClient.getEmployeeById(id);
    }
}
