package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDob(employee.getDob());
        employeeDto.setRole(String.valueOf(employee.getRole()));
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDob(employeeDto.getDob());
        employee.setRole(Employee.Role.valueOf(String.valueOf(employeeDto.getRole())));
        return employee;
    }
}
