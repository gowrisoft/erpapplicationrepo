package com.gentech.erp.hr.entity;
import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_joining_report")
public class JoiningReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "joining_id")
    private Long joiningId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "status")
    private String status;

    @NotNull(message = "Date of joining cannot be null")
    @Column(nullable = false)
    private Date dateOfJoining;
    
    @OneToOne 
    @JoinColumn(name = "joining_emp_id", referencedColumnName = "emp_id")
    private Employee joiningEmployee;
    
    @ManyToOne
    @JoinColumn(name = "reporting_manager", referencedColumnName = "emp_id")
    private Employee reportingManager;
    
    @ManyToOne
    @JoinColumn(name = "verified_by_admin_id", referencedColumnName = "emp_id")
    private Employee joinadminId;

   
    public JoiningReport() 
    {	
    	
    }

    public JoiningReport(Long joiningId,String firstName,String lastName,String designation, String status, Date dateOfJoining,Employee joiningEmployee, Employee reportingManager, Employee joinadminId) 
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
