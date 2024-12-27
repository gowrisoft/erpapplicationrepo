package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_biometric_attendance")
public class BiometricAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biometric_id")
    private Long biometricId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Column(name = "time_in")
    private LocalTime timeIn;

    @Column(name = "time_out")
    private LocalTime timeOut;

    @Column(name = "total_hours_worked", precision = 5, scale = 2)
    private BigDecimal totalHoursWorked;

    @Column(name = "duty_type", length = 255)
    private String dutyType;

    // Relationship with Employee (Many BiometricAttendance records for one Employee)
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    // Relationship with BiometricPunchingReport (Many BiometricAttendance records map to one BiometricPunchingReport)

    public BiometricAttendance() {

    }

    public BiometricAttendance(Long biometricId, LocalDate attendanceDate, LocalTime timeIn, LocalTime timeOut,
                               BigDecimal totalHoursWorked, String dutyType, Employee employee) {
        super();
        this.biometricId = biometricId;
        this.attendanceDate = attendanceDate;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.totalHoursWorked = totalHoursWorked;
        this.dutyType = dutyType;
        this.employee = employee;
    }

    // Getters and Setters
    public Long getBiometricId() {
        return biometricId;
    }

    public void setBiometricId(Long biometricId) {
        this.biometricId = biometricId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public BigDecimal getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(BigDecimal totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
