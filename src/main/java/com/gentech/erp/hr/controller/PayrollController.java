package com.gentech.erp.hr.controller;


import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.service.PayrollService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/admin/payroll/calculate")
    public ResponseEntity<PayrollDto> calculatePayroll(@RequestParam Long employeeId,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate salaryDate) {
        return ResponseEntity.ok(payrollService.calculatePayroll(employeeId, salaryDate));
    }

    @GetMapping("/admin/payroll/empId/{employeeId}")
    public ResponseEntity<List<PayrollDto>> getPayrollHistory(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.getPayrollByEmpId(employeeId));
    }

    @GetMapping("/user/payroll")
    public ResponseEntity<List<PayrollDto>> getPayrollHistory(HttpServletRequest request) {
        return ResponseEntity.ok(payrollService.getPayrollByEmpId((Long) request.getAttribute("employeeId")));
    }

    @PostMapping("/admin/payroll")
    public ResponseEntity<PayrollDto> createPayroll(@RequestBody PayrollDto payrollDto) {
        return ResponseEntity.ok(payrollService.createPayroll(payrollDto));
    }

    @GetMapping("/admin/payroll/all")
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    @GetMapping("/admin/payroll/payrollId/{payrollId}")
    public ResponseEntity<PayrollDto> getPayroll(@PathVariable Long payrollId) {
        return ResponseEntity.ok(payrollService.getPayrollById(payrollId));
    }

    @PutMapping("/admin/payroll/{id}")
    public ResponseEntity<PayrollDto> updatePayroll(@PathVariable Long id, @RequestBody PayrollDto updatedPayroll) {
        return ResponseEntity.ok(payrollService.updatePayroll(id, updatedPayroll));
    }

    @DeleteMapping("/admin/payroll/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}