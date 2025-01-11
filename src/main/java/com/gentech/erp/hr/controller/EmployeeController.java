package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/")
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.OK);
    }

    @GetMapping("/employee/all")
    ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, updatedEmployee));
    }

    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/user/employee/profile")
    ResponseEntity<EmployeeDto> getEmployeeProfile(HttpServletRequest request) {
        return new ResponseEntity<>(employeeService.getEmployeeById((Long) request.getAttribute("employeeId")), HttpStatus.OK);
    }
}