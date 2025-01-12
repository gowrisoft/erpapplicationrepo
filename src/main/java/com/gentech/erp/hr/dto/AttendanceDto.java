package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;

import java.sql.Date;

public class AttendanceDto {
    private Long attendanceId;
    private Date attendanceDate;
    private String attendanceStatus;
    private Employee admin;
    private Employee employee;

    public AttendanceDto() {

    }

    public AttendanceDto(Long attendanceId, Date attendanceDate, String attendanceStatus, Employee admin,
                         Employee employee) {
        super();
        this.attendanceId = attendanceId;
        this.attendanceDate = attendanceDate;
        this.attendanceStatus = attendanceStatus;
        this.admin = admin;
        this.employee = employee;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Employee getAdmin() {
        return admin;
    }

    public void setAdmin(Employee admin) {
        this.admin = admin;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
