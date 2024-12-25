package com.gentech.erp.hr.controller;

import java.util.List;

import com.gentech.erp.hr.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.service.EmployeeService;

@RestController
@RequestMapping("user/v1/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/addEmployee")
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.OK);
    }

    @GetMapping("/allEmployees")
    ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById")
    ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, updatedEmployee));
    }

    @DeleteMapping("/deleteEmployeeById")
    ResponseEntity<String> deleteEmployeeById(@RequestParam long id){
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id),HttpStatus.OK);
    }
}