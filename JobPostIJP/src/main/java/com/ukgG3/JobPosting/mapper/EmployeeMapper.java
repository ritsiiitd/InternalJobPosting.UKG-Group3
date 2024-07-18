package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.JobPosting;
import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.dto.JobPostingDto;
import com.ukgG3.JobPosting.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setEmployee_id(employee.getEmployeeId());
        employeeDto.setFirst_name(employee.getFirstName());
        employeeDto.setLast_name(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDob(employee.getDob());
        employeeDto.setRole(String.valueOf(employee.getERole()));
        employeeDto.setPassword(employee.getPassword());
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {
        employee.setEmployeeId(employeeDto.getEmployee_id());
        employee.setFirstName(employeeDto.getFirst_name());
        employee.setLastName(employeeDto.getLast_name());
        employee.setEmail(employeeDto.getEmail());
        employee.setDob(employeeDto.getDob());
        employee.setERole(employeeDto.getRole());
        employee.setPassword(employeeDto.getPassword());
        return employee;
    }

}
