package com.gentech.erp.hr.serviceimpl;


import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.Payroll;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.PayrollRepository;
import com.gentech.erp.hr.service.PayrollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PayrollDto calculatePayroll(Long emp_id, LocalDate salaryDate) {
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        BigDecimal grossSalary = employee.getBaseSalary().add(employee.getAllowances());
        BigDecimal tax = grossSalary.multiply(BigDecimal.valueOf(0.10)); // 10% Tax
        BigDecimal providentFund = employee.getBaseSalary().multiply(BigDecimal.valueOf(0.05)); // 5% PF
        BigDecimal deductions = tax.add(providentFund);
        BigDecimal netSalary = grossSalary.subtract(deductions);

        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setSalaryDate(salaryDate);
        payroll.setGrossSalary(grossSalary);
        payroll.setDeductions(deductions);
        payroll.setNetSalary(netSalary);

        payrollRepository.save(payroll);

        return modelMapper.map(payroll, PayrollDto.class);
    }

    @Override
    public List<PayrollDto> getPayrollHistory(Long emp_id) {

        return payrollRepository.findByEmployee_EmpId(emp_id)
                .stream().map(payroll -> modelMapper.map(payroll, PayrollDto.class)).collect(Collectors.toList());
    }

    @Override
    public PayrollDto createPayroll(Long emp_id, Payroll payroll) {
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        payroll.setEmployee(employee);
        return modelMapper.map(payrollRepository.save(payroll), PayrollDto.class);
    }

    @Override
    public PayrollDto getPayrollById(Long payroll_id) {
        return modelMapper.map(payrollRepository.findById(payroll_id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll record not found")), PayrollDto.class);
    }

    @Override
    public void deletePayroll(Long payroll_id) {
        if (!payrollRepository.existsById(payroll_id)) {
            throw new ResourceNotFoundException("Payroll record not found");
        }
        payrollRepository.deleteById(payroll_id);
    }
}
