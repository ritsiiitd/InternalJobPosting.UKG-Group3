package com.ukgG3.JobPosting.controller;

import com.ukgG3.JobPosting.dto.EmployeeDto;
import com.ukgG3.JobPosting.dto.ResponseDto;
import com.ukgG3.JobPosting.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class IJPcontroller {

    @Autowired
    private final EmployeeService employeeService;


    @GetMapping("/getAll")
    public List<EmployeeDto> getAllEmployees() {
        System.out.println("Inside getAllEmployees" + employeeService.getAllEmployees());
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getById")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World This is Employees service!");
    }
}
