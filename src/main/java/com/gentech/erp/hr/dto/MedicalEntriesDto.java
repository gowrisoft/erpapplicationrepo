package com.gentech.erp.hr.dto;

import java.util.Date;
import com.gentech.erp.hr.entity.Dependant;

public class MedicalEntriesDto {
    private Long medicalEntryId;
    private Long dependantId;
    private byte[] medicalFiles;
    private Double requestAmount;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public MedicalEntriesDto() {
    }

    public Long getMedicalEntryId() {
        return medicalEntryId;
    }

    public void setMedicalEntryId(Long medicalEntryId) {
        this.medicalEntryId = medicalEntryId;
    }

    public Long getDependantId() {
        return dependantId;
    }

    public void setDependantId(Long dependantId) {
        this.dependantId = dependantId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}