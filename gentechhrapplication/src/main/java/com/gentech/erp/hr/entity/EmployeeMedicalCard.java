package com.gentech.erp.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "tbl_employeecard")
@Entity
public class EmployeeMedicalCard {

    @Id
    private String eCard;


    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "empIdMedical", referencedColumnName = "emp_id") // Ensure "empId" matches the primary key of Employee
    private Employee employee;


    @OneToMany(mappedBy = "medicalCard")
    @JsonIgnore
    private List<Dependants> dependants;

    public EmployeeMedicalCard() {
    }

    public EmployeeMedicalCard(String eCard, Employee employee, List<Dependants> dependants) {
        this.eCard = eCard;
        this.employee = employee;
        this.dependants = dependants;
    }

    @JsonProperty("cardId")
    public String geteCard() {
        return eCard;
    }

    public void seteCard(String eCard) {
        this.eCard = eCard;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Dependants> getDependants() {
        return dependants;
    }

    public void setDependants(List<Dependants> dependants) {
        this.dependants = dependants;
    }
}
