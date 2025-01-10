package com.gentech.erp.hr.dto;
import java.sql.Date;

public class CompensatoryLeaveDto {
    private int compensatoryLeaveId;
    private Date leaveDate;
    private String compensatoryReason;
    private Date startDate;
    private Date endDate;
    private long empId;

    public CompensatoryLeaveDto(){

    }

    public CompensatoryLeaveDto(int compensatoryLeaveId, Date leaveDate, String compensatoryReason, Date startDate, Date endDate, long empId) {
        this.compensatoryLeaveId = compensatoryLeaveId;
        this.leaveDate = leaveDate;
        this.compensatoryReason = compensatoryReason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.empId = empId;
    }

    public int getCompensatoryLeaveId() {
        return compensatoryLeaveId;
    }

    public void setCompensatoryLeaveId(int compensatoryLeaveId) {
        this.compensatoryLeaveId = compensatoryLeaveId;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getCompensatoryReason() {
        return compensatoryReason;
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

    public void setCompensatoryReason(String compensatoryReason) {
        this.compensatoryReason = compensatoryReason;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }
}
