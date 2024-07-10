package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setFirst_name(employee.getFirstName());
        employeeDto.setLast_name(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDob(employee.getDob());
        employeeDto.setRole(String.valueOf(employee.getERole()));
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {
        employee.setFirstName(employeeDto.getFirst_name());
        employee.setLastName(employeeDto.getLast_name());
        employee.setEmail(employeeDto.getEmail());
        employee.setDob(employeeDto.getDob());
        employee.setERole(Employee.Role.valueOf(String.valueOf(employeeDto.getRole())));
        return employee;
    }
}
