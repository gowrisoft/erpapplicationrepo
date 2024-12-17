package com.gentech.erp.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.service.EmployeeService;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/addEmployee")
    ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<EmployeeDto>(employeeService.addEmployee(employeeDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/allEmployees")
    ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getEmployeeById")
    ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam long id){
        return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteEmployeeById")
    ResponseEntity<String> deleteEmployeeById(@RequestParam long id){
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(id),HttpStatusCode.valueOf(200));
    }
}
