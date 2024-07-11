package com.ukgG3.JobPosting.service;

// EmployeeService.java

//import com.ukgG3.Application.dto.ApplicationDto;
import com.ukgG3.JobPosting.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    boolean saveEmployee(EmployeeDto employeeDTO);
    void deleteEmployee(Long id);

//    void postApplication(ApplicationDto applicationDTO);
}
