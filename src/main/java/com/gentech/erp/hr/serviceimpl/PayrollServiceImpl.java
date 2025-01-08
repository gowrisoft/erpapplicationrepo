package com.gentech.erp.hr.serviceimpl;


import com.gentech.erp.hr.dto.PayrollDto;
import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.Payroll;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.ApprovedMedicalClaimRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.PayrollRepository;
import com.gentech.erp.hr.service.PayrollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private ApprovedMedicalClaimRepository approvedMedicalClaimRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PayrollDto calculatePayroll(Long empId, LocalDate salaryDate) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + empId));

        BigDecimal baseSalary = employee.getBaseSalary();
        BigDecimal allowances = employee.getAllowances();

        List<ApprovedMedicalClaim> medicalClaims = approvedMedicalClaimRepository.findByEmployeeEmpId(empId);

        BigDecimal medicalExpenses = medicalClaims.stream()
                .map(claim -> BigDecimal.valueOf(claim.getApprovedAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal grossSalary = baseSalary.add(allowances).add(medicalExpenses);

        BigDecimal tax = baseSalary.multiply(BigDecimal.valueOf(0.10)); // 10% Tax only on baseSalary
        BigDecimal providentFund = baseSalary.multiply(BigDecimal.valueOf(0.05)); // 5% PF
        BigDecimal deductions = tax.add(providentFund);

        BigDecimal netSalary = grossSalary.subtract(deductions);

        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setSalaryDate(salaryDate);
        payroll.setBaseSalary(baseSalary);
        payroll.setAllowances(allowances);
        payroll.setMedicalExpenses(medicalExpenses);
        payroll.setGrossSalary(grossSalary);
        payroll.setTax(tax);
        payroll.setProvidentFund(providentFund);
        payroll.setDeductions(deductions);
        payroll.setNetSalary(netSalary);

        payrollRepository.save(payroll);
        return modelMapper.map(payroll, PayrollDto.class);
    }


    @Override
    public List<PayrollDto> getPayrollByEmpId(Long emp_id) {
        return payrollRepository.findByEmployee_EmpId(emp_id)
                .stream().map(payroll -> modelMapper.map(payroll, PayrollDto.class)).toList();
    }

    @Override
    public List<PayrollDto> getAllPayrolls() {
        return payrollRepository.findAll()
                .stream().map(payroll -> modelMapper.map(payroll, PayrollDto.class)).toList();
    }

    @Override
    public PayrollDto createPayroll(PayrollDto payrollDto) {
        Employee employee = employeeRepository.findById(payrollDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Payroll payroll = modelMapper.map(payrollDto, Payroll.class);
        payroll.setEmployee(employee);
        return modelMapper.map(payrollRepository.save(payroll), PayrollDto.class);
    }

    @Override
    public PayrollDto getPayrollById(Long payroll_id) {
        return modelMapper.map(payrollRepository.findById(payroll_id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll record not found")), PayrollDto.class);
    }

    @Override
    public PayrollDto updatePayroll(Long id, PayrollDto updatedPayroll) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll record not found"));
        payroll.setSalaryDate(updatedPayroll.getSalaryDate());
        payroll.setGrossSalary(updatedPayroll.getGrossSalary());
        payroll.setDeductions(updatedPayroll.getDeductions());
        payroll.setNetSalary(updatedPayroll.getNetSalary());
        return modelMapper.map(payrollRepository.save(payroll), PayrollDto.class);
    }

    @Override
    public void deletePayroll(Long payroll_id) {
        if (!payrollRepository.existsById(payroll_id)) {
            throw new ResourceNotFoundException("Payroll record not found");
        }
        payrollRepository.deleteById(payroll_id);
    }
}
