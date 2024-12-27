package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class BiometricAttendanceDto {
    private Long biometricId;
    private LocalDate attendanceDate;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private BigDecimal totalHoursWorked;
    private String dutyType;
    private Employee employee;


    public BiometricAttendanceDto() {

    }


    public BiometricAttendanceDto(Long biometricId, LocalDate attendanceDate, LocalTime timeIn, LocalTime timeOut,
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
