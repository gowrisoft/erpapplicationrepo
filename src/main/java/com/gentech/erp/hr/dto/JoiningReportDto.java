package com.gentech.erp.hr.dto;

import java.sql.Date;

import com.gentech.erp.hr.entity.Employee; // Import Employee entity

public class JoiningReportDto {
    private Long joiningId;
    private String empName;
    private String designation;
    private String status;
    private Date joiningDate;
    private Employee joiningEmployee;
    private Employee admin;
    private Employee reportingManager;


    public JoiningReportDto() {}

    public JoiningReportDto(Long joiningId, String empName, String designation, String status, Date joiningDate, Employee joiningEmployee, Employee admin, Employee reportingManager) {
        this.joiningId = joiningId;
        this.empName = empName;
        this.designation = designation;
        this.status = status;
        this.joiningDate = joiningDate;
        this.joiningEmployee = joiningEmployee;
        this.admin = admin;
        this.reportingManager = reportingManager;
    }

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

    public Employee getAdmin() {
        return admin;
    }

    public void setAdminId(Employee admin) {
        this.admin = admin;
    }

    public Employee getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(Employee reportingManager) {
        this.reportingManager = reportingManager;
    }
}
