package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.CompensatoryLeave.CompensatoryStatus;

import java.sql.Date;

public class CompensatoryLeaveDto {
    private int compensatoryLeaveId;
    private Date leaveDate;
    private String compensatoryReason;
    private String approvedBy;
    private CompensatoryLeave.CompensatoryStatus compensatoryStatus;
    private long empId;

    public CompensatoryLeaveDto(int compensatoryLeaveId, Date leaveDate, String compensatoryReason, String approvedBy,
                                CompensatoryStatus compensatoryStatus, long empId) {
        super();
        this.compensatoryLeaveId = compensatoryLeaveId;
        this.leaveDate = leaveDate;
        this.compensatoryReason = compensatoryReason;
        this.approvedBy = approvedBy;
        this.compensatoryStatus = compensatoryStatus;
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

    public void setCompensatoryReason(String compensatoryReason) {
        this.compensatoryReason = compensatoryReason;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public CompensatoryLeave.CompensatoryStatus getCompensatoryStatus() {
        return compensatoryStatus;
    }

    public void setCompensatoryStatus(CompensatoryLeave.CompensatoryStatus compensatoryStatus) {
        this.compensatoryStatus = compensatoryStatus;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }
}
