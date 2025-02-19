package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "apply_leave")
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_req_id")
    private int leaveRequestId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "reason")
    private String reason;
    @Column(name = "type_of_leave")
    private String typeOfLeave;
    @Column(name = "status", nullable = true, columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String status;


    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;
    @OneToOne(mappedBy = "leaveApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private SanctionLeave sanctionLeave;
    @OneToOne(mappedBy = "leaveApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    private LeaveLedger leaveLedger;

    public LeaveApplication() {
    }

    public LeaveApplication(int leaveRequestId, Date startDate, Date endDate, String reason, String typeOfLeave, String status, Employee employee, SanctionLeave sanctionLeave, LeaveLedger leaveLedger) {
        this.leaveRequestId = leaveRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.typeOfLeave = typeOfLeave;
        this.status = status;
        this.employee = employee;
        this.sanctionLeave = sanctionLeave;
        this.leaveLedger = leaveLedger;
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
