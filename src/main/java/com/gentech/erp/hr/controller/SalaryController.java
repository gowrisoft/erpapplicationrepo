package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.SalaryDto;
import com.gentech.erp.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<SalaryDto> saveSalary(@RequestBody SalaryDto salary) {
        try {
            SalaryDto savedSalary = salaryService.saveSalary(salary);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSalary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SalaryDto>> getAllSalaries() {
        return ResponseEntity.ok(salaryService.getAllSalaries());
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<SalaryDto> getSalaryByEmployeeId(@PathVariable Long empId) throws Exception {
        SalaryDto salary = salaryService.getSalaryByEmployeeId(empId);
        if (salary != null) {
            return ResponseEntity.ok(salary);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SalaryDto> updateByid(@RequestBody  SalaryDto upd,@PathVariable Long id)throws Exception
    {
        upd.setSalId(id);
        return new ResponseEntity<SalaryDto>(salaryService.updateItem(upd,id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) throws Exception
    {
        salaryService.deleteItemById(id);
        return new ResponseEntity<String>("Item with Id "+id+" was successfully deleted",HttpStatusCode.valueOf(200));
    }
}
