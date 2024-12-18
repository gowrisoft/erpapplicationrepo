package com.gentech.erp.hr.dto;

import java.sql.Date;

import com.gentech.erp.hr.entity.LeaveLedger;
import com.gentech.erp.hr.entity.LeaveLedger.LeaveStatus;

public class LeaveLedgerDto {
	public LeaveLedgerDto(int ledgerId, int leaveAccrued, Date date, String leaveType, int leaveUsed, int leaveBalance,
			String remarks, LeaveStatus status, String processedBy, long empId, int leaveRequestId,
			int compensatoryLeaveId) {
		super();
		this.ledgerId = ledgerId;
		this.leaveAccrued = leaveAccrued;
		this.date = date;
		this.leaveType = leaveType;
		this.leaveUsed = leaveUsed;
		this.leaveBalance = leaveBalance;
		this.remarks = remarks;
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
	public int getLeaveAccrued() {
		return leaveAccrued;
	}
	public void setLeaveAccrued(int leaveAccrued) {
		this.leaveAccrued = leaveAccrued;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public int getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public int getCompensatoryLeaveId() {
		return compensatoryLeaveId;
	}
	public void setCompensatoryLeaveId(int compensatoryLeaveId) {
		this.compensatoryLeaveId = compensatoryLeaveId;
	}
	private int ledgerId;
    private int leaveAccrued;
    private Date date;
    private String leaveType;
    private int leaveUsed;
    private int leaveBalance;
    private String remarks;
    private LeaveLedger.LeaveStatus status;
    private String processedBy;
    private long empId;
    private int leaveRequestId;
    private int compensatoryLeaveId;
}
