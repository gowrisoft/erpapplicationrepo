package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Dependants;
import com.gentech.erp.hr.entity.Employee;

import java.util.List;

public class EmployeeMedicalCardDto {
    private String eCard;
    private Employee employee;
    private List<Dependants> dependants;

    public EmployeeMedicalCardDto(){

    }
    public EmployeeMedicalCardDto(String eCard, Employee employee, List<Dependants> dependants) {
        this.eCard = eCard;
        this.employee = employee;
        this.dependants = dependants;
    }

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
