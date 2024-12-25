package com.gentech.erp.hr.controller;


import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.Payroll;
import com.gentech.erp.hr.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/calculate")
    public ResponseEntity<PayrollDto> calculatePayroll(@RequestParam Long employeeId,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate salaryDate) {
        return ResponseEntity.ok(payrollService.calculatePayroll(employeeId, salaryDate));
    }

    @GetMapping("/history/{employeeId}")
    public ResponseEntity<List<PayrollDto>> getPayrollHistory(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.getPayrollHistory(employeeId));
    }

    @PostMapping
    public ResponseEntity<PayrollDto> createPayroll(@RequestParam Long employeeId, @RequestBody Payroll payroll) {
        return ResponseEntity.ok(payrollService.createPayroll(employeeId, payroll));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollDto> getPayroll(@PathVariable Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
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