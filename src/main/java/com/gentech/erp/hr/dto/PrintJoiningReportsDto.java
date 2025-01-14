package com.gentech.erp.hr.dto;

import java.sql.Date;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;

public class PrintJoiningReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private JoiningReport printJoiningId;
    private Employee printadminId;
    private Employee printempId;
    private String firstName;
    private String lastName;
    
    
    public PrintJoiningReportsDto(Long printId, Date printDate, JoiningReport printJoiningId, Employee printadminId,Employee printempId, String status,String firstName,String lastName) {
		this.printId = printId;
		this.printDate = printDate;
		this.printJoiningId = printJoiningId;
		this.printadminId = printadminId;
		this.printempId = printempId;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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



}
