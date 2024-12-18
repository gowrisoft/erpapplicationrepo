package com.gentech.erp.hr.dto;


import java.sql.Date;

import com.gentech.erp.hr.entity.Employee;
 // Import Employee entity

public class JoiningReportDto {
    private Long joiningId;
    private String empName;
    private String designation;
    private String status;
    private Date joiningDate;
    private Employee joiningEmployee; // Add this field
    private Employee reportingManagerId; // Add this field

    // Default constructor
    public JoiningReportDto() {
    }

    // Constructor with all fields
    public JoiningReportDto(Long joiningId, String empName, String designation, String status, Date joiningDate, Employee joiningEmployee, Employee reportingManagerId) {
        this.joiningId = joiningId;
        this.empName = empName;
        this.designation = designation;
        this.status = status;
        this.joiningDate = joiningDate;
        this.joiningEmployee = joiningEmployee;
        this.reportingManagerId = reportingManagerId;
    }

    // Getters and Setters
    public Long getJoiningId() {
        return joiningId;
    }

    public void setJoiningId(Long joiningId) {
        this.joiningId = joiningId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee getJoiningEmployee() {
        return joiningEmployee;
    }

    public void setJoiningEmployee(Employee joiningEmployee) {
        this.joiningEmployee = joiningEmployee;
    }

    public Employee getReportingManagerId() {
        return reportingManagerId;
    }

    public void setReportingManagerId(Employee reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }
}
