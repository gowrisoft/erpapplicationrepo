package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Dependant;

public class MedicalEntriesDto {
    private Long medicalEntryId;
    private Dependant dependant;
    private byte[] medicalFiles;
    private Double requestAmount;

    public MedicalEntriesDto() {
    }

    public MedicalEntriesDto(Long medicalEntryId, Dependant dependant, byte[] medicalFiles, Double requestAmount) {
        this.medicalEntryId = medicalEntryId;
        this.dependant = dependant;
        this.medicalFiles = medicalFiles;
        this.requestAmount = requestAmount;
    }

    public Long getMedicalEntryId() {
        return medicalEntryId;
    }

    public void setMedicalEntryId(Long medicalEntryId) {
        this.medicalEntryId = medicalEntryId;
    }

    public Dependant getDependant() {
        return dependant;
    }

    public void setDependant(Dependant dependant) {
        this.dependant = dependant;
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