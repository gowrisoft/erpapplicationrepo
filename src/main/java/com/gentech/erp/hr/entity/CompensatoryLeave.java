package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "compensatory_leave")
public class CompensatoryLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensatory_leave_id")
    private int compensatoryLeaveId;
    @Column(name = "leave_date")
    private Date leaveDate;
    @Column(name = "compensatory_reason")
    private String compensatoryReason;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "status", nullable = true, columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String status;


    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id", nullable = false)
    private Employee employee;
    @OneToOne(mappedBy = "compensatoryLeave", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveLedger leaveLedger;
    @OneToOne(mappedBy = "compensatoryLeave", cascade = CascadeType.ALL, orphanRemoval = true)
    private SanctionLeave sanctionLeave;

    public CompensatoryLeave() {

    }

    public CompensatoryLeave(int compensatoryLeaveId, Date leaveDate, String compensatoryReason, Date startDate, Date endDate, String status, Employee employee, LeaveLedger leaveLedger, SanctionLeave sanctionLeave) {
        this.compensatoryLeaveId = compensatoryLeaveId;
        this.leaveDate = leaveDate;
        this.compensatoryReason = compensatoryReason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.employee = employee;
        this.leaveLedger = leaveLedger;
        this.sanctionLeave = sanctionLeave;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SanctionLeave getSanctionLeave() {
        return sanctionLeave;
    }

    public void setSanctionLeave(SanctionLeave sanctionLeave) {
        this.sanctionLeave = sanctionLeave;
    }

    public LeaveLedger getLeaveLedger() {
        return leaveLedger;
    }

    public void setLeaveLedger(LeaveLedger leaveLedger) {
        this.leaveLedger = leaveLedger;
    }

}

