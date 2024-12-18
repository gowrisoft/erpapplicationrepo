package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "tbl_dependents")
@Entity
public class Dependants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dependantId;

    private String dependantName;
    private Integer dependantAge;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eCardIdDep", referencedColumnName = "eCard") // Ensure "id" matches the primary key of EmployeeMedicalCard
    private EmployeeMedicalCard medicalCard;

    public Dependants() {
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



    public Dependants(String dependantName, Integer dependantAge, EmployeeMedicalCard medicalCard) {
        super();
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
        this.medicalCard = medicalCard;
    }

}