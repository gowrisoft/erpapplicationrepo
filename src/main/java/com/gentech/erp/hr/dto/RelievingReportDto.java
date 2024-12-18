package com.gentech.erp.hr.dto;
import java.sql.Date;

import com.gentech.erp.hr.entity.Employee;
public class RelievingReportDto {
    private Long relievingId;
    private String empName;
    private String designation;
    private Employee relievingEmployee;
    private String reason;
    private String status;
    private Date relievingDate;

    public Long getRelievingId() {
        return relievingId;
    }

    public void setRelievingId(Long relievingId) {
        this.relievingId = relievingId;
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

    public Employee getRelievingEmployee() {
        return relievingEmployee;
    }

    public void setRelievingEmployee(Employee relievingEmployee) {
        this.relievingEmployee = relievingEmployee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRelievingDate() {
        return relievingDate;
    }

    public void setRelievingDate(Date relievingDate) {
        this.relievingDate = relievingDate;
    }
    
    public RelievingReportDto(){

    }
    public RelievingReportDto(Long relievingId, String empName, String designation, Employee relievingEmployee, String reason, String status, Date relievingDate) {
        this.relievingId = relievingId;
        this.empName = empName;
        this.designation = designation;
        this.relievingEmployee = relievingEmployee;
        this.reason = reason;
        this.status = status;
        this.relievingDate = relievingDate;
    }
}
