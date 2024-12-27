package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Dependant;
import jakarta.validation.constraints.NotNull;

public class DependantsDto {
    @NotNull
    private Long dependantId;

    @NotNull
    private Long employeeId;

    @NotNull
    private String dependantName;

    @NotNull
    private Integer dependantAge;

    @NotNull
    private Dependant.RelationshipType relationship;

    public DependantsDto() {
    }

    public DependantsDto(Long dependantId, Long employeeId, String dependantName, Integer dependantAge, Dependant.RelationshipType relationship) {
        this.dependantId = dependantId;
        this.employeeId = employeeId;
        this.dependantName = dependantName;
        this.dependantAge = dependantAge;
        this.relationship = relationship;
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

    public Dependant.RelationshipType getRelationship() {
        return relationship;
    }

    public void setRelationship(Dependant.RelationshipType relationship) {
        this.relationship = relationship;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
