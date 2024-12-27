package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

@Table(name = "tbl_dependents")
@Entity
public class Dependants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dependantId;

    private String dependantName;
    private Integer dependantAge;

    public Dependants() {
    }

    public Dependants(Long dependantId, String dependantName, Integer dependantAge) {
        this.dependantId = dependantId;
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
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
}