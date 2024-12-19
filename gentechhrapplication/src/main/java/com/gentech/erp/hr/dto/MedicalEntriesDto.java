package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Dependants;
import com.gentech.erp.hr.entity.Employee;

public class MedicalEntriesDto {
    private Long MRno;
    private Employee employee;
    private Dependants dependants;
    private String medicalFiles;
    private Double requestAmount;

    public MedicalEntriesDto(){

    }

    public Long getMRno() {
        return MRno;
    }

    public void setMRno(Long MRno) {
        this.MRno = MRno;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Dependants getDependants() {
        return dependants;
    }

    public void setDependants(Dependants dependants) {
        this.dependants = dependants;
    }

    public String getMedicalFiles() {
        return medicalFiles;
    }

    public void setMedicalFiles(String medicalFiles) {
        this.medicalFiles = medicalFiles;
    }

    public Double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Double requestAmount) {
        this.requestAmount = requestAmount;
    }
}
