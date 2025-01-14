package com.gentech.erp.hr.dto;

import java.sql.Date;
import com.gentech.erp.hr.entity.Employee;

public class JoiningReportDto {
    private Long joiningId;
    private String firstName;
    private String lastName;
    private String designation;
    private String status;
    private Date dateOfJoining;
    private Employee joiningEmployee;
    private Employee joinadminId;
    private Employee reportingManager;


    // Default constructor
    public JoiningReportDto() {}

    
    public JoiningReportDto(Long joiningId,String firstName,String lastName,String designation, String status, Date dateOfJoining,Employee joiningEmployee, Employee reportingManager, Employee joinadminId) 
    {

		this.joiningId = joiningId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.status = status;
		this.dateOfJoining = dateOfJoining;
		this.joiningEmployee = joiningEmployee;
		this.reportingManager = reportingManager;
		this.joinadminId = joinadminId;
	}

    // Getters and Setters
    public Long getJoiningId() {
		return joiningId;
	}

	public void setJoiningId(Long joiningId) {
		this.joiningId = joiningId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Employee getJoiningEmployee() {
		return joiningEmployee;
	}

	public void setJoiningEmployee(Employee joiningEmployee) {
		this.joiningEmployee = joiningEmployee;
	}

	public Employee getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}

	public Employee getJoinadminId() {
		return joinadminId;
	}

	public void setJoinadminId(Employee joinadminId) {
		this.joinadminId = joinadminId;
	}
}
