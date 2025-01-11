package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;
import com.gentech.erp.hr.entity.Admin;
import java.sql.Date;

public class RelievingReportDto {
    private Long relievingId;
    private String empName;
    private String designation;
    private Employee relievingEmployee;
    private String reason;
    private String status;
    private Date relievingDate;
    private Admin reladminId;
    private JoiningReport relJoiningId;

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

    public Admin getReladminId() {
        return reladminId;
    }

    public void setReladminId(Admin reladminId) {
        this.reladminId=reladminId;
    }

    public JoiningReport getRelJoiningId() {
        return relJoiningId;
    }

    public void setRelJoiningId(JoiningReport relJoiningId) {
        this.relJoiningId=relJoiningId;
    }

    public RelievingReportDto(){

    }
    public RelievingReportDto(Long relievingId, String empName, String designation, Employee relievingEmployee, String reason, String status, Date relievingDate,Admin reladminId,JoiningReport relJoiningId) {
        this.relievingId = relievingId;
        this.empName = empName;
        this.designation = designation;
        this.relievingEmployee = relievingEmployee;
        this.reason = reason;
        this.status = status;
        this.relievingDate = relievingDate;
        this.reladminId=reladminId;
        this.relJoiningId=relJoiningId;
    }
}
