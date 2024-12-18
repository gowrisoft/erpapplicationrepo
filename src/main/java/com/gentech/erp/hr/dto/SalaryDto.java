package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;

public class SalaryDto {
    private Employee employee;
    private Long salId;
    private Double basicSalary;
    private Double medicalClaim;

    public SalaryDto(){

    }

    public SalaryDto(Employee employee, Long salId, Double basicSalary, Double medicalClaim) {
        this.employee = employee;
        this.salId = salId;
        this.basicSalary = basicSalary;
        this.medicalClaim = medicalClaim;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getSalId() {
        return salId;
    }

    public void setSalId(Long salId) {
        this.salId = salId;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getMedicalClaim() {
        return medicalClaim;
    }

    public void setMedicalClaim(Double medicalClaim) {
        this.medicalClaim = medicalClaim;
    }
}
