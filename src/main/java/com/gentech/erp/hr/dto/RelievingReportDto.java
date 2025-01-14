package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.Employee;

import com.gentech.erp.hr.entity.JoiningReport;

import java.sql.Date;

public class RelievingReportDto {
	private Long relievingId;
    private String firstName;
    private String lastName;
    private String designation;
    private Employee relievingEmployee;
    private String reason;
    private String status;
    private Date relievingDate;
    private Employee reladminId;
    private JoiningReport relJoiningId;

    public RelievingReportDto(Long relievingId,
			String firstName,String lastName,String designation, Employee relievingEmployee, Employee reladminId, JoiningReport relJoiningId,
			String reason, String status, Date relievingDate) {
		this.relievingId = relievingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.relievingEmployee = relievingEmployee;
		this.reladminId = reladminId;
		this.relJoiningId = relJoiningId;
		this.reason = reason;
		this.status = status;
		this.relievingDate = relievingDate;
	}

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employee getRelievingEmployee() {
		return relievingEmployee;
	}

	public void setRelievingEmployee(Employee relievingEmployee) {
		this.relievingEmployee = relievingEmployee;
	}

	public Employee getReladminId() {
		return reladminId;
	}

	public void setReladminId(Employee reladminId) {
		this.reladminId = reladminId;
	}

	public JoiningReport getRelJoiningId() {
		return relJoiningId;
	}

	public void setRelJoiningId(JoiningReport relJoiningId) {
		this.relJoiningId = relJoiningId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(Date relievingDate) {
		this.relievingDate = relievingDate;
	}

	public void setRelievingId(Long relievingId) {
		this.relievingId = relievingId;
	}
	
	public Long getRelievingId() {
		return relievingId;
	}

}
