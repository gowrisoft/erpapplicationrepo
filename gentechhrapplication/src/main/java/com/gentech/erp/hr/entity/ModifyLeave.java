package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "modify_leave")
public class ModifyLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modify_leave_id")
    private int modifyLeaveId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "new_start_date")
    private Date newStartDate;
    @Column(name = "new_end_date")
    private Date newEndDate;
    @Column(name = "new_leave_type")
    private String newLeaveType;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "leave_req_id", nullable = false)
    private LeaveApplication leaveApplication;

    public ModifyLeave() {

    }

    public ModifyLeave(int modifyLeaveId, String empName, Date modifiedDate, Date newStartDate, Date newEndDate,
                       String newLeaveType, Employee employee, LeaveApplication leaveApplication) {
        super();
        this.modifyLeaveId = modifyLeaveId;
        this.empName = empName;
        this.modifiedDate = modifiedDate;
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
        this.newLeaveType = newLeaveType;
        this.employee = employee;
        this.leaveApplication = leaveApplication;
    }

    public int getModifyLeaveId() {
        return modifyLeaveId;
    }

    public void setModifyLeaveId(int modifyLeaveId) {
        this.modifyLeaveId = modifyLeaveId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getNewStartDate() {
        return newStartDate;
    }

    public void setNewStartDate(Date newStartDate) {
        this.newStartDate = newStartDate;
    }

    public Date getNewEndDate() {
        return newEndDate;
    }

    public void setNewEndDate(Date newEndDate) {
        this.newEndDate = newEndDate;
    }

    public String getNewLeaveType() {
        return newLeaveType;
    }

    public void setNewLeaveType(String newLeaveType) {
        this.newLeaveType = newLeaveType;
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
}