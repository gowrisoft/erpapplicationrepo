package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "tbl_salary")
@Entity
public class Salary {

    @Id
    private Long salId;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "empId", referencedColumnName = "emp_id")
    private Employee employee;

    private Double basicSalary;
    private Double medicalClaim;

    public Salary() {}

    public Salary(Long salId, Employee employee, Double basicSalary, Double medicalClaim) {
        this.salId = salId;
        this.employee = employee;
        this.basicSalary = basicSalary;
        this.medicalClaim = medicalClaim;
    }

    public Long getSalId() {
        return salId;
    }

    public void setSalId(Long salId) {
        this.salId = salId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

