package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class MedicalEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MRno;

    @ManyToOne
    @JoinColumn(name = "dependants_dependant_id", referencedColumnName = "dependantId")
    private Dependants dependants;

    private String medicalFiles;

    private Double requestAmount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "empIdMedical", referencedColumnName = "emp_id")
    private Employee employee;


    public MedicalEntries() {
    }

    public MedicalEntries(Long MRno, Dependants dependants, String medicalFiles, Double requestAmount, Employee employee) {
        this.MRno = MRno;
        this.dependants = dependants;
        this.medicalFiles = medicalFiles;
        this.requestAmount = requestAmount;
        this.employee = employee;
    }

    public Long getMRno() {
        return MRno;
    }

    public void setMRno(Long MRno) {
        this.MRno = MRno;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

