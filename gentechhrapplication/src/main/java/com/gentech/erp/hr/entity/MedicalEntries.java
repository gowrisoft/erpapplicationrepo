package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class MedicalEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalEntryId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dependant_id", referencedColumnName = "dependantId")
    private Dependant dependant;

    @Lob
    private byte[] medicalFiles;

    private Double requestAmount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public MedicalEntries() {
    }

    public MedicalEntries(Long medicalEntryId, Dependant dependant, byte[] medicalFiles, Double requestAmount, Date date, Date date2) {
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

    public Dependant getDependants() {
        return dependant;
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

    public Dependant getDependant() {
        return dependant;
    }

    public void setDependant(Dependant dependant) {
        this.dependant = dependant;
    }

}