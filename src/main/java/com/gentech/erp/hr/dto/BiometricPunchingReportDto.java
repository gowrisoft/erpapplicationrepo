package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.BiometricAttendance;
import com.gentech.erp.hr.entity.Employee;

import java.time.LocalDate;
import java.time.LocalTime;

public class BiometricPunchingReportDto {
    private Integer reportId;
    private Employee employee;
    private String empName;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private Integer numOfPunches;
    private String location;
    private String designation;
    private BiometricAttendance biometricAttendance;

    public BiometricPunchingReportDto() {

    }

    public BiometricPunchingReportDto(Integer reportId, Employee employee, String empName, LocalDate date,
                                      LocalTime timeIn, LocalTime timeOut, Integer numOfPunches, String location, String designation,
                                      BiometricAttendance biometricAttendance) {
        super();
        this.reportId = reportId;
        this.employee = employee;
        this.empName = empName;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.numOfPunches = numOfPunches;
        this.location = location;
        this.designation = designation;
        this.biometricAttendance = biometricAttendance;
    }

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
