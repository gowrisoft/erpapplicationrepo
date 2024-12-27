package com.gentech.erp.hr.dto;

import java.sql.Date;

public class ModifyLeaveDto {
    private int modifyLeaveId;
    private String empName;
    private Date modifiedDate;
    private Date newStartDate;
    private Date newEndDate;
    private String newLeaveType;
    private long empId;
    private int leaveRequestId;

    public ModifyLeaveDto(int modifyLeaveId, String empName, Date modifiedDate, Date newStartDate, Date newEndDate,
                          String newLeaveType, long empId, int leaveRequestId) {
        super();
        this.modifyLeaveId = modifyLeaveId;
        this.empName = empName;
        this.modifiedDate = modifiedDate;
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
        this.newLeaveType = newLeaveType;
        this.empId = empId;
        this.leaveRequestId = leaveRequestId;
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
}
