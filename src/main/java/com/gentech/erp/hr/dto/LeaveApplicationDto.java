package com.gentech.erp.hr.dto;

import java.sql.Date;

public class LeaveApplicationDto {
    private int leaveRequestId;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String typeOfLeave;
    private String status;
    private long empId;

    public LeaveApplicationDto(int leaveRequestId, Date startDate, Date endDate, String reason, String typeOfLeave, String status, long empId) {
        this.leaveRequestId = leaveRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.typeOfLeave = typeOfLeave;
        this.status = status;
        this.empId = empId;
    }

    public int getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }
}
