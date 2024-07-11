package com.ukgG3.JobPosting.controller;

//import com.ukgG3.Application.dto.ApplicationDto;
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


    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public boolean createEmployee(@RequestBody EmployeeDto employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

//    @PutMapping("/{id}")
//    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
//        employeeDTO.se(id);
//        return employeeService.saveEmployee(employeeDTO);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }
}
