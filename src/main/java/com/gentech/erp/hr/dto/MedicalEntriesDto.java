package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.EmployeeMedicalCard;

public class MedicalEntriesDto {
    private Long MRno;
    private Employee employee;
    private EmployeeMedicalCard medicalCard;
    private String dependantName;
    private Integer dependantAge;
    private byte[] medicalFiles;
    private Double requestAmount;

    public MedicalEntriesDto(){

    }

    public MedicalEntriesDto(Long MRno, Employee employee, EmployeeMedicalCard medicalCard, String dependantName, Integer dependantAge, byte[] medicalFiles, Double requestAmount) {
        this.MRno = MRno;
        this.employee = employee;
        this.medicalCard = medicalCard;
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
        this.medicalFiles = medicalFiles;
        this.requestAmount = requestAmount;
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

    public EmployeeMedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(EmployeeMedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getDependantName() {
        return dependantName;
    }

    public void setDependantName(String dependantName) {
        this.dependantName = dependantName;
    }

    public Integer getDependantAge() {
        return dependantAge;
    }

    public void setDependantAge(Integer dependantAge) {
        this.dependantAge = dependantAge;
    }

    public byte[] getMedicalFiles() {
        return medicalFiles;
    }

    public void setMedicalFiles(byte[] medicalFiles) {
        this.medicalFiles = medicalFiles;
    }

    public Double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Double requestAmount) {
        this.requestAmount = requestAmount;
    }
}
