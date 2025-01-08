package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "attendance_date")
    private Date attendanceDate;

    @Column(name = "attendance_status")
    private String attendanceStatus;

    // Many-to-One relationship with Admin
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    // Many-to-One relationship with Employee
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    public Attendance() {
    }

    public Attendance(Date attendanceDate, String attendanceStatus) {
        this.attendanceDate = attendanceDate;
        this.attendanceStatus = attendanceStatus;
    }


    public Attendance(Long attendanceId, Date attendanceDate, String attendanceStatus, Admin admin, Employee employee) {
        super();
        this.attendanceId = attendanceId;
        this.attendanceDate = attendanceDate;
        this.attendanceStatus = attendanceStatus;
        this.admin = admin;
        this.employee = employee;
    }

    // Getters and Setters
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
