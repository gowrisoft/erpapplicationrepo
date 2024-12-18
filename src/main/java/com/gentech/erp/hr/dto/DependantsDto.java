package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.EmployeeMedicalCard;

public class DependantsDto {
    private Long dependantId;
    private String dependantName;
    private Integer dependantAge;
    private EmployeeMedicalCard medicalCard;

    public DependantsDto(){

    }

    public DependantsDto(Long dependantId, String dependantName, Integer dependantAge, EmployeeMedicalCard medicalCard) {
        this.dependantId = dependantId;
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
        this.medicalCard = medicalCard;
    }

    public Long getDependantId() {
        return dependantId;
    }

    public void setDependantId(Long dependantId) {
        this.dependantId = dependantId;
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

    public EmployeeMedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(EmployeeMedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }
}
