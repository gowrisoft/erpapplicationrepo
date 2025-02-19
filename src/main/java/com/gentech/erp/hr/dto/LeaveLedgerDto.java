package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.LeaveLedger;
import com.gentech.erp.hr.entity.LeaveLedger.LeaveStatus;

import java.sql.Date;

public class LeaveLedgerDto {
    private int ledgerId;
    private Integer leaveAccrued;
    private String leaveType;
    private int leaveUsed;
    private int leaveBalance;
    private LeaveLedger.LeaveStatus status;
    private String processedBy;
    private long empId;
    private Integer leaveRequestId;
    private Integer compensatoryLeaveId;

    public LeaveLedgerDto(int ledgerId, Integer leaveAccrued, String leaveType, int leaveUsed, int leaveBalance, LeaveStatus status, String processedBy, long empId, Integer leaveRequestId, Integer compensatoryLeaveId) {
        this.ledgerId = ledgerId;
        this.leaveAccrued = leaveAccrued;
        this.leaveType = leaveType;
        this.leaveUsed = leaveUsed;
        this.leaveBalance = leaveBalance;
        this.status = status;
        this.processedBy = processedBy;
        this.empId = empId;
        this.leaveRequestId = leaveRequestId;
        this.compensatoryLeaveId = compensatoryLeaveId;
    }

    public int getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public Integer getLeaveAccrued() {
        return leaveAccrued;
    }

    public void setLeaveAccrued(Integer leaveAccrued) {
        this.leaveAccrued = leaveAccrued;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getLeaveUsed() {
        return leaveUsed;
    }

    public void setLeaveUsed(int leaveUsed) {
        this.leaveUsed = leaveUsed;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public LeaveLedger.LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveLedger.LeaveStatus status) {
        this.status = status;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public Integer getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Integer leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Integer getCompensatoryLeaveId() {
        return compensatoryLeaveId;
    }

    public void setCompensatoryLeaveId(Integer compensatoryLeaveId) {
        this.compensatoryLeaveId = compensatoryLeaveId;
    }
}
