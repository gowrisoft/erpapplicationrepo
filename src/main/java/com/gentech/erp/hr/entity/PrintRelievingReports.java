package com.gentech.erp.hr.entity;

import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_print_relieving_report")
public class PrintRelievingReports{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne
    @JoinColumn(name = "print_Relieving_id", referencedColumnName = "relieving_id")
    private RelievingReport printRelievingId;
    
    @ManyToOne
    @JoinColumn(name = "print_admin_id", referencedColumnName = "emp_id")
    private Employee printadminId;
    
    
    @ManyToOne
    @JoinColumn(name = "print_Joining_id", referencedColumnName = "joining_id")
    private JoiningReport printJoiningId;
    
    @ManyToOne
    @JoinColumn(name = "print_emp_id", referencedColumnName = "Emp_id")
    private Employee printempId;
    
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @Column(name = "status")
    private String status;
    
    public PrintRelievingReports() {
    	
    }
    

	public PrintRelievingReports(Long printId, Date printDate, RelievingReport printRelievingId, Employee printadminId,JoiningReport printJoiningId, Employee printempId,
			String firstName,String lastName,String status) {
		this.printId = printId;
		this.printDate = printDate;
		this.printRelievingId = printRelievingId;
		this.printadminId = printadminId;
		this.printJoiningId = printJoiningId;
		this.printempId = printempId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}


	public Long getPrintId() {
		return printId;
	}


	public void setPrintId(Long printId) {
		this.printId = printId;
	}


	public Date getPrintDate() {
		return printDate;
	}


	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}


	public RelievingReport getPrintRelievingId() {
		return printRelievingId;
	}


	public void setPrintRelievingId(RelievingReport printRelievingId) {
		this.printRelievingId = printRelievingId;
	}


	public Employee getPrintadminId() {
		return printadminId;
	}


	public void setPrintadminId(Employee printadminId) {
		this.printadminId = printadminId;
	}


	public JoiningReport getPrintJoiningId() {
		return printJoiningId;
	}


	public void setPrintJoiningId(JoiningReport printJoiningId) {
		this.printJoiningId = printJoiningId;
	}


	public Employee getPrintempId() {
		return printempId;
	}


	public void setPrintempId(Employee printempId) {
		this.printempId = printempId;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	}
