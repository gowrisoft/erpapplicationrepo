package com.gentech.erp.hr.entity;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_print_joining_report")
public class PrintJoiningReports{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne
    @JoinColumn(name = "print_joining_id", referencedColumnName = "joining_id")
    private JoiningReport printJoiningId;
    
    @ManyToOne
    @JoinColumn(name = "print_admin_id", referencedColumnName = "emp_id")
    private Employee printadminId;
    
    @ManyToOne
    @JoinColumn(name = "print_emp_id", referencedColumnName = "emp_id")
    private Employee printempId;
    
    @NotNull(message = "Base salary cannot be null")
    @Column(nullable = false) // Ensures database-level constraint
    private BigDecimal baseSalary;
    
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @Column(name = "designation")
    private String designation;
    
    public PrintJoiningReports() {
    	
    }
    
	public PrintJoiningReports(Long printId, Date printDate, JoiningReport printJoiningId, Employee printadminId,Employee printempId, BigDecimal baseSalary,String firstName,String lastName,String designation) {
		this.printId = printId;
		this.printDate = printDate;
		this.printJoiningId = printJoiningId;
		this.printadminId = printadminId;
		this.printempId = printempId;
		this.baseSalary=baseSalary;;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
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

	public JoiningReport getPrintJoiningId() {
		return printJoiningId;
	}

	public void setPrintJoiningId(JoiningReport printJoiningId) {
		this.printJoiningId = printJoiningId;
	}

	public Employee getPrintadminId() {
		return printadminId;
	}

	public void setPrintadminId(Employee printadminId) {
		this.printadminId = printadminId;
	}

	public Employee getPrintempId() {
		return printempId;
	}

	public void setPrintempId(Employee printempId) {
		this.printempId = printempId;
	}

	public BigDecimal getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		this.baseSalary = baseSalary;
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

}
