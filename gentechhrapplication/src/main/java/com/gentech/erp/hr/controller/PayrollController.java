package com.gentech.erp.hr.controller;


import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/calculate")
    public ResponseEntity<PayrollDto> calculatePayroll(@RequestParam Long employeeId,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate salaryDate) {
        return ResponseEntity.ok(payrollService.calculatePayroll(employeeId, salaryDate));
    }

    @GetMapping("/empId/{employeeId}")
    public ResponseEntity<List<PayrollDto>> getPayrollHistory(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.getPayrollByEmpId(employeeId));
    }

    @PostMapping
    public ResponseEntity<PayrollDto> createPayroll(@RequestBody PayrollDto payrollDto) {
        return ResponseEntity.ok(payrollService.createPayroll(payrollDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    @GetMapping("/payrollId/{payrollId}")
    public ResponseEntity<PayrollDto> getPayroll(@PathVariable Long payrollId) {
        return ResponseEntity.ok(payrollService.getPayrollById(payrollId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollDto> updatePayroll(@PathVariable Long id, @RequestBody PayrollDto updatedPayroll) {
        return ResponseEntity.ok(payrollService.updatePayroll(id, updatedPayroll));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}