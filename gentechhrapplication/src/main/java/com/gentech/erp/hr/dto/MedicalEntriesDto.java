package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Dependant;

public class MedicalEntriesDto {
    private Long MRno;
    private Dependant dependant;
    private byte[] medicalFiles;
    private Double requestAmount;

    public MedicalEntriesDto() {

    }

    public Long getMRno() {
        return MRno;
    }

    public void setMRno(Long MRno) {
        this.MRno = MRno;
    }

    public Dependant getDependant() {
        return dependant;
    }

    public void setDependant(Dependant dependants) {
        this.dependant = dependants;
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