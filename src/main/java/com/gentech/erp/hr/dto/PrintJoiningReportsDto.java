package com.gentech.erp.hr.dto;

import java.sql.Date;

import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.JoiningReport;

public class PrintJoiningReportsDto {
    private Long printId;
    private String status;
    private Date printDate;
    private JoiningReport printJoiningId;
    private Admin printadminId;
    
    public Long getPrintId() {
		return printId;
	}

	public void setPrintId(Long printId) {
		this.printId = printId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Admin getPrintadminId() {
		return printadminId;
	}

	public void setPrintadminId(Admin printadminId) {
		this.printadminId = printadminId;
	}


	public PrintJoiningReportsDto()
    {

    }

	public PrintJoiningReportsDto(Long printId, String status, Date printDate, JoiningReport printJoiningId,
			Admin printadminId) {
		super();
		this.printId = printId;
		this.status = status;
		this.printDate = printDate;
		this.printJoiningId = printJoiningId;
		this.printadminId = printadminId;
	}

}
