package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "leave_ledger")
public class LeaveLedger {
	public LeaveLedger(){
		
	}
    public LeaveLedger(int ledgerId, int leaveAccrued, Date date, String leaveType, int leaveUsed, int leaveBalance,
			String remarks, LeaveStatus status, String processedBy, Employee employee,
			LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeave) {
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
		this.employee = employee;
		this.leaveApplication = leaveApplication;
		this.compensatoryLeave = compensatoryLeave;
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

	public LeaveStatus getStatus() {
		return status;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public String getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveApplication getLeaveApplication() {
		return leaveApplication;
	}

	public void setLeaveApplication(LeaveApplication leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public CompensatoryLeave getCompensatoryLeave() {
		return compensatoryLeave;
	}

	public void setCompensatoryLeave(CompensatoryLeave compensatoryLeave) {
		this.compensatoryLeave = compensatoryLeave;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ledger_id")
    private int ledgerId;
    @Column(name = "leave_accrued")
    private int leaveAccrued;
    @Column(name = "date")
    private Date date;
    @Column(name = "leave_type")
    private String leaveType;
    @Column(name = "leave_used")
    private int leaveUsed;
    @Column(name = "leave_balance")
    private int leaveBalance;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "application_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private LeaveStatus status;
    @Column(name = "processed_by")
    private String processedBy;

    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_req_id",referencedColumnName = "leave_req_id")
    private LeaveApplication leaveApplication;

    @OneToOne
    @JoinColumn(name = "compensatory_leave_id", referencedColumnName = "compensatory_leave_id", nullable = false)
    private CompensatoryLeave compensatoryLeave;

    public enum LeaveStatus{
        ACTIVE,
        CLOSED,
        PENDING
    }
}

