package com.gentech.erp.hr.dto;

import java.sql.Date;


import com.gentech.erp.hr.entity.Employee;

public class AttendanceDto {
	private Long attendanceId;
    private Date attendanceDate;
    private String attendanceStatus;
    private Employee employee;
    
    public AttendanceDto() {
    	
    }
    
	public AttendanceDto(Long attendanceId, Date attendanceDate, String attendanceStatus,
			Employee employee) {
	
		this.attendanceId = attendanceId;
		this.attendanceDate = attendanceDate;
		this.attendanceStatus = attendanceStatus;
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

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}
