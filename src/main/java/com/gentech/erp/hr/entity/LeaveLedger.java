package com.gentech.erp.hr.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "leave_ledger")
public class LeaveLedger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ledger_id")
    private int ledgerId;

    @Column(name = "leave_accrued",columnDefinition = "int default 100")
    private Integer leaveAccrued;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "leave_used")
    private int leaveUsed;

    @Column(name = "leave_balance")
    private int leaveBalance;

    @Column(name = "application_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    @Column(name = "processed_by")
    private String processedBy;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "leave_req_id", referencedColumnName = "leave_req_id", nullable=true)
    private LeaveApplication leaveApplication;

    @OneToOne
    @JoinColumn(name = "compensatory_leave_id", referencedColumnName = "compensatory_leave_id", nullable = true)
    private CompensatoryLeave compensatoryLeave;

    // No-argument constructor
    public LeaveLedger() {
    }

    // All-argument constructor

    public LeaveLedger(int ledgerId, Integer leaveAccrued, String leaveType, int leaveUsed, int leaveBalance, LeaveStatus status, String processedBy, Employee employee, LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeave) {
        this.ledgerId = ledgerId;
        this.leaveAccrued = leaveAccrued;
        this.leaveType = leaveType;
        this.leaveUsed = leaveUsed;
        this.leaveBalance = leaveBalance;
        this.status = status;
        this.processedBy = processedBy;
        this.employee = employee;
        this.leaveApplication = leaveApplication;
        this.compensatoryLeave = compensatoryLeave;
    }

    // Getter and Setter methods
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

    // Enum for Leave Status
    public enum LeaveStatus {
        APPROVED,
        REJECTED,
        PENDING
    }
}
