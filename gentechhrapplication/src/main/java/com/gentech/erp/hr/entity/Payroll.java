package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;

    @NotNull
    @Column(nullable = false)
    private LocalDate salaryDate;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal baseSalary;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal allowances;

    @Column(precision = 10, scale = 2)
    private BigDecimal medicalExpenses;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal grossSalary;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tax;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal providentFund;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal deductions;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal netSalary;

    public Payroll() {
    }

    public Payroll(Long payrollId, Employee employee, LocalDate salaryDate, BigDecimal baseSalary, BigDecimal allowances, BigDecimal medicalExpenses, BigDecimal grossSalary, BigDecimal tax, BigDecimal providentFund, BigDecimal deductions, BigDecimal netSalary) {
        this.payrollId = payrollId;
        this.employee = employee;
        this.salaryDate = salaryDate;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
        this.medicalExpenses = medicalExpenses;
        this.grossSalary = grossSalary;
        this.tax = tax;
        this.providentFund = providentFund;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public Long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(LocalDate salaryDate) {
        this.salaryDate = salaryDate;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getAllowances() {
        return allowances;
    }

    public void setAllowances(BigDecimal allowances) {
        this.allowances = allowances;
    }

    public BigDecimal getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(BigDecimal medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(BigDecimal providentFund) {
        this.providentFund = providentFund;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }
}
