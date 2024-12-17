package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.Payroll;

import java.time.LocalDate;
import java.util.List;

public interface PayrollService {


    PayrollDto calculatePayroll(Long employeeId, LocalDate salaryDate);

    List<PayrollDto> getPayrollHistory(Long employeeId);

    PayrollDto createPayroll(Long employeeId, Payroll payroll);

    PayrollDto getPayrollById(Long id);

    void deletePayroll(Long id);
}