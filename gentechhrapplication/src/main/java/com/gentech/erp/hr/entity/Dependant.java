package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Dependant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dependantId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;

    private String dependantName;
    private Integer dependantAge;

    @Enumerated(EnumType.STRING)
    private RelationshipType relationship;

    public Dependant() {
    }

    public Dependant(Long dependantId, Employee employee, String dependantName, Integer dependantAge, RelationshipType relationship) {
        this.dependantId = dependantId;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public RelationshipType getRelationship() {
        return relationship;
    }

    public void setRelationship(RelationshipType relationship) {
        this.relationship = relationship;
    }

    public enum RelationshipType {
        SPOUSE,
        CHILD,
        PARENT
    }
}