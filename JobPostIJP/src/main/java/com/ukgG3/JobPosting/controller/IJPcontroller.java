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

//    @PostMapping("/addEmployee")
//    public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeeDto employeeDTO) {
//        employeeService.saveEmployee(employeeDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Created Successfully"));
//    }

//    @PutMapping("/{id}")
//    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
//        employeeDTO.se(id);
//        return employeeService.saveEmployee(employeeDTO);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World This is Employees service!");
    }
}
