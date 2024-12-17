package com.gentech.hr.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_biometric_punching_report")
public class BiometricPunchingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;

    // Relationship: Many-to-One with Employee (emp_code references Employee)
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    // This is redundant now because it's already part of the employee relationship
    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time_in", nullable = false)
    private LocalTime timeIn;

    @Column(name = "time_out", nullable = false)
    private LocalTime timeOut;

    @Column(name = "num_of_punches")
    private Integer numOfPunches;

    @Column(name = "location")
    private String location;

    @Column(name = "designation")
    private String designation;

    // Relationship: Many-to-One with BiometricAttendance
    @ManyToOne
    @JoinColumn(name = "biometric_id", nullable = false)
    private BiometricAttendance biometricAttendance;

    // Removed redundant empCode

    // Getters and Setters
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Integer getNumOfPunches() {
        return numOfPunches;
    }

    public void setNumOfPunches(Integer numOfPunches) {
        this.numOfPunches = numOfPunches;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BiometricAttendance getBiometricAttendance() {
        return biometricAttendance;
    }

    public void setBiometricAttendance(BiometricAttendance biometricAttendance) {
        this.biometricAttendance = biometricAttendance;
    }
}
