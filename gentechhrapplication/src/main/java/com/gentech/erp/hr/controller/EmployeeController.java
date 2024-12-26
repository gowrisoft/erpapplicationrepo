package com.gentech.erp.hr.controller;

import java.util.List;

import com.gentech.erp.hr.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, updatedEmployee));
    }

    @DeleteMapping("/deleteEmployeeById")
    ResponseEntity<String> deleteEmployeeById(@RequestParam long id){
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(id),HttpStatusCode.valueOf(200));
    }
}
