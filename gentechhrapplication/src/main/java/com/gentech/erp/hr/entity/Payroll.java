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
    private BigDecimal grossSalary;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal deductions;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal netSalary;

    @Column(precision = 10, scale = 2)
    private BigDecimal medicalExpenses;

    public Payroll(Long payrollId, Employee employee, LocalDate salaryDate, BigDecimal grossSalary, BigDecimal deductions, BigDecimal netSalary, BigDecimal medicalExpenses) {
        this.payrollId = payrollId;
        this.employee = employee;
        this.salaryDate = salaryDate;
        this.grossSalary = grossSalary;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.medicalExpenses = medicalExpenses;
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

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
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

    public BigDecimal getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(BigDecimal medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    public Payroll() {

    }
}


