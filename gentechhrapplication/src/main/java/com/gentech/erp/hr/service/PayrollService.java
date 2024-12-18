package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.Payroll;

import java.time.LocalDate;
import java.util.List;

public interface PayrollService {


    PayrollDto calculatePayroll(Long employeeId, LocalDate salaryDate);

    List<PayrollDto> getPayrollHistory(Long employeeId);

    List<PayrollDto> getAllPayrolls();

    PayrollDto createPayroll(Long employeeId, Payroll payroll);

    PayrollDto getPayrollById(Long id);

    PayrollDto updatePayroll(Long id, PayrollDto updatedPayroll);

    void deletePayroll(Long id);
}