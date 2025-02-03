package com.gentech.erp.hr.dto;

public class EmployeeUserDTO {
    private Long empId;
    private String firstName;
    private String lastName;
    private String empDesignation;

    public EmployeeUserDTO() {
    }

    public EmployeeUserDTO(Long empId, String firstName, String lastName, String empDesignation) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empDesignation = empDesignation;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }
}