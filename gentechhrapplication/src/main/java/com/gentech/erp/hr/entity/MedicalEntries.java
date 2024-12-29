package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

@Entity
public class MedicalEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalEntryId;

    @ManyToOne
    @JoinColumn(name = "dependant_id", referencedColumnName = "dependantId")
    private Dependant dependant;

    @Lob
    private byte[] medicalFiles;

    private Double requestAmount;

    public MedicalEntries() {
    }

    public MedicalEntries(Long medicalEntryId, Dependant dependant, byte[] medicalFiles, Double requestAmount) {
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