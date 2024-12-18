package com.gentech.erp.hr.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_joining_report")
public class JoiningReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "joining_id")
    private Long joiningId;

    @Column(name = "employee_name")
    private String empName;

    @Column(name = "designation")
    private String designation;
    
    @Column(name = "status")
    private String status;

    @Column(name = "joining_date")
    private Date joiningDate;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "joining_emp_id", referencedColumnName = "Emp_id")
    private Employee joiningEmployee; // One-to-One relationship for joining employee

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reporting_manager_id", referencedColumnName = "Emp_id")
    private Employee reportingManagerId; // Many-to-One relationship for reporting manager

    // Default Constructor
    public JoiningReport() {}

    public JoiningReport(Long joiningId, String empName, String designation, String status, Date joiningDate,
			Employee joiningEmployee, Employee reportingManagerId) {
		super();
		this.joiningId = joiningId;
		this.empName = empName;
		this.designation = designation;
		this.status = status;
		this.joiningDate = joiningDate;
		this.joiningEmployee = joiningEmployee;
		this.reportingManagerId = reportingManagerId;
	}

	public JoiningReport(String empName, String designation, String status, Date joiningDate, Employee joiningEmployee,
			Employee reportingManagerId) {
		super();
		this.empName = empName;
		this.designation = designation;
		this.status = status;
		this.joiningDate = joiningDate;
		this.joiningEmployee = joiningEmployee;
		this.reportingManagerId = reportingManagerId;
	}

	public Long getJoiningId() {
		return joiningId;
	}

	public void setJoiningId(Long joiningId) {
		this.joiningId = joiningId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee getJoiningEmployee() {
		return joiningEmployee;
	}

	public void setJoiningEmployee(Employee joiningEmployee) {
		this.joiningEmployee = joiningEmployee;
	}

	public Employee getReportingManagerId() {
		return reportingManagerId;
	}

	public void setReportingManagerId(Employee reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}

	
}