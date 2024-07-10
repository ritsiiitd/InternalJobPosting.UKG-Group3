package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.Dto.EmployeeDto;
import com.ukgG3.JobPosting.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setFirst_name(employee.getFirst_name());
        employeeDto.setLast_name(employee.getLast_name());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDob(employee.getDob());
        employeeDto.setRole(EmployeeDto.Role.valueOf(String.valueOf(employee.getRole())));
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {
        employee.setFirst_name(employeeDto.getFirst_name());
        employee.setLast_name(employeeDto.getLast_name());
        employee.setEmail(employeeDto.getEmail());
        employee.setDob(employeeDto.getDob());
        employee.setRole(Employee.Role.valueOf(String.valueOf(employeeDto.getRole())));
        return employee;
    }
}
