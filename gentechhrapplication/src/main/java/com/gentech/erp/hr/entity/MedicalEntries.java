package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

@Entity
public class MedicalEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MRno;

    @ManyToOne
    @JoinColumn(name = "dependant_id", referencedColumnName = "dependantId")
    private Dependant dependant;

    @Lob
    private byte[] medicalFiles;

    private Double requestAmount;

    public MedicalEntries() {
    }

    public MedicalEntries(Long MRno, Dependant dependant, byte[] medicalFiles, Double requestAmount) {
        this.MRno = MRno;
        this.dependant = dependant;
        this.medicalFiles = medicalFiles;
        this.requestAmount = requestAmount;
    }

    public Long getMRno() {
        return MRno;
    }

    public void setMRno(Long MRno) {
        this.MRno = MRno;
    }

    public Dependant getDependants() {
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