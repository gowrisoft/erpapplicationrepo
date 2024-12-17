package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "compensatory_leave")
public class CompensatoryLeave{
    public CompensatoryLeave(int compensatoryLeaveId, Date leaveDate, String compensatoryReason, String approvedBy,
			CompensatoryStatus compensatoryStatus, Employee employee, LeaveLedger leaveLedger) {
		super();
		this.compensatoryLeaveId = compensatoryLeaveId;
		this.leaveDate = leaveDate;
		this.compensatoryReason = compensatoryReason;
		this.approvedBy = approvedBy;
		this.compensatoryStatus = compensatoryStatus;
		this.employee = employee;
		this.leaveLedger = leaveLedger;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensatory_leave_id")
    private int compensatoryLeaveId;

    @Column(name = "leave_date")
    private Date leaveDate;

    @Column(name = "compensatory_reason")
    private String compensatoryReason;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "compensatory_leave_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private CompensatoryStatus compensatoryStatus;

    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id",nullable = false)
    private Employee employee;

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

	public CompensatoryStatus getCompensatoryStatus() {
		return compensatoryStatus;
	}

	public void setCompensatoryStatus(CompensatoryStatus compensatoryStatus) {
		this.compensatoryStatus = compensatoryStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LeaveLedger getLeaveLedger() {
		return leaveLedger;
	}

	public void setLeaveLedger(LeaveLedger leaveLedger) {
		this.leaveLedger = leaveLedger;
	}

	@OneToOne(mappedBy = "compensatoryLeave", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveLedger leaveLedger;

    public enum CompensatoryStatus{
        APPROVED,
        REJECTED,
        PENDING
    }
}

