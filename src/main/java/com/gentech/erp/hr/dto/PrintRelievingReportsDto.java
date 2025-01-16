package com.gentech.erp.hr.dto;

import java.sql.Date;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;
import com.gentech.erp.hr.entity.RelievingReport;

public class PrintRelievingReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private RelievingReport printRelievingId;
    private Employee printadminId;
    private JoiningReport printJoiningId;
    private Employee printempId;
    private String firstName;
    private String lastName;
    

	public PrintRelievingReportsDto(Long printId, Date printDate, RelievingReport printRelievingId, Employee printadminId,JoiningReport printJoiningId, Employee printempId,
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
