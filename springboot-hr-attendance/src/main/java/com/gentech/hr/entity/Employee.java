package com.gentech.hr.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long employeeId;
	@Column(name = "emp_name")
	private String employeeName;
	@Column(name = "designation")
	private String designation;
	@Column(name = "emp_email")
	private String email;
	@Column(name = "emp_phone")
	private String phoneNo;
	@Column(name = "joining_date")
	private String joiningDate;
	
	public Employee() {
		
	}
	
	public Employee(String employeeName, String designation, String email, String phoneNo, String joiningDate) {
		super();
		this.employeeName = employeeName;
		this.designation = designation;
		this.email = email;
		this.phoneNo = phoneNo;
		this.joiningDate = joiningDate;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}
