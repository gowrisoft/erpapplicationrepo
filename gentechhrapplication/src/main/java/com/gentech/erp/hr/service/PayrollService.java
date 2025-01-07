package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.Payroll;

import java.time.LocalDate;
import java.util.List;

public interface PayrollService {


    PayrollDto calculatePayroll(Long employeeId, LocalDate salaryDate);

    List<PayrollDto> getPayrollByEmpId(Long employeeId);

    List<PayrollDto> getAllPayrolls();

    PayrollDto createPayroll(PayrollDto payroll);

    PayrollDto getPayrollById(Long id);

    PayrollDto updatePayroll(Long id, PayrollDto updatedPayroll);

    void deletePayroll(Long id);
}