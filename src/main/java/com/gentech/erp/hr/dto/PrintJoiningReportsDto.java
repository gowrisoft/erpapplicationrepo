package com.gentech.erp.hr.dto;

import java.math.BigDecimal;
import java.sql.Date;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;

public class PrintJoiningReportsDto {
    private Long printId;
    private BigDecimal baseSalary;
    private Date printDate;
    private JoiningReport printJoiningId;
    private Employee printadminId;
    private Employee printempId;
    private String firstName;
    private String lastName;
    private String designation;
    
    
    public PrintJoiningReportsDto(Long printId, Date printDate, JoiningReport printJoiningId, Employee printadminId,Employee printempId, BigDecimal baseSalary,String firstName,String lastName,String designation) {
		this.printId = printId;
		this.printDate = printDate;
		this.printJoiningId = printJoiningId;
		this.printadminId = printadminId;
		this.printempId = printempId;
		this.baseSalary=baseSalary;
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
