package com.ukgG3.JobPosting.service.impl;

import com.ukgG3.JobPosting.entity.Employee;
import com.ukgG3.JobPosting.repository.EmployeeRepository;
import com.ukgG3.JobPosting.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements IAccountsService {
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {

    }
}
