package com.gentech.erp.hr.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee{
    public Employee(long empId, String empName, String empEmail, long empPhone, String empDesignation, Date joiningDate,
			List<LeaveApplication> leaveApplications, List<ModifyLeave> modifyLeaves, List<LeaveLedger> leaveLedgers,
			List<CompensatoryLeave> compensatoryLeaveEntities) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empDesignation = empDesignation;
		this.joiningDate = joiningDate;
		this.leaveApplications = leaveApplications;
		this.modifyLeaves = modifyLeaves;
		this.leaveLedgers = leaveLedgers;
		this.compensatoryLeaveEntities = compensatoryLeaveEntities;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_email")
    private String empEmail;
    public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public long getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public List<LeaveApplication> getLeaveApplications() {
		return leaveApplications;
	}
	public void setLeaveApplications(List<LeaveApplication> leaveApplications) {
		this.leaveApplications = leaveApplications;
	}
	public List<ModifyLeave> getModifyLeaves() {
		return modifyLeaves;
	}
	public void setModifyLeaves(List<ModifyLeave> modifyLeaves) {
		this.modifyLeaves = modifyLeaves;
	}
	public List<LeaveLedger> getLeaveLedgers() {
		return leaveLedgers;
	}
	public void setLeaveLedgers(List<LeaveLedger> leaveLedgers) {
		this.leaveLedgers = leaveLedgers;
	}
	public List<CompensatoryLeave> getCompensatoryLeaveEntities() {
		return compensatoryLeaveEntities;
	}
	public void setCompensatoryLeaveEntities(List<CompensatoryLeave> compensatoryLeaveEntities) {
		this.compensatoryLeaveEntities = compensatoryLeaveEntities;
	}
	@Column(name= "emp_phone")
    private long empPhone;
    @Column(name = "designation")
    private String empDesignation;
    @Column(name = "joining_date")
    private Date joiningDate;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveApplication> leaveApplications;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModifyLeave> modifyLeaves;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveLedger> leaveLedgers;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompensatoryLeave> compensatoryLeaveEntities;
}