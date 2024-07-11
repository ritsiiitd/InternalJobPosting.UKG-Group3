package com.ukgG3.JobPosting.service.impl;

// EmployeeServiceImpl.java

import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.entity.Employee;
import com.ukgG3.JobPosting.mapper.EmployeeMapper;
import com.ukgG3.JobPosting.repository.EmployeeRepository;
import com.ukgG3.JobPosting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
            .map(employee ->
                    {
                        return EmployeeMapper.mapToEmployeeDto(employee, new EmployeeDto());
                    })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    return EmployeeMapper.mapToEmployeeDto(employee, new EmployeeDto());
                })
                .orElse(null);
    }

    @Override
    public boolean saveEmployee(EmployeeDto employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO,new Employee());
        return true;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
