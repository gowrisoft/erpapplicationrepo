package com.gentech.hr.entity;

import java.sql.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_print_relieving_report")
public class PrintRelievingReports{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "print_id")
    private Long printId;

    @Column(name = "print_date")
    private Date printDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "print_relieving_id", referencedColumnName = "relieving_id")
    private RelievingReport printRelievingId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "print_admin_id", referencedColumnName = "admin_id")
    private Admin printadminId;
    
    @Column(name = "status")
    private String status;
    
    public PrintRelievingReports()
    {
    	
    }

	public PrintRelievingReports(Date printDate, RelievingReport printRelievingId, Admin printadminId, String status) {
		super();
		this.printDate = printDate;
		this.printRelievingId = printRelievingId;
		this.printadminId = printadminId;
		this.status = status;
	}

	public Long getPrintRelievingId() {
		return printId;
	}

	public void setPrintRelievingId(Long printId) {
		this.printId = printId;
	}

	public Date getPrintRelievingDate() {
		return printDate;
	}

	public void setPrintRelievingDate(Date printDate) {
		this.printDate = printDate;
	}

	public RelievingReport getPrintRelievingRelievingId() {
		return printRelievingId;
	}

	public void setPrintRelievingRelievingId(RelievingReport printRelievingId) {
		this.printRelievingId = printRelievingId;
	}

	public Admin getPrintRelievingadminId() {
		return printadminId;
	}

	public void setPrintRelievingadminId(Admin printadminId) {
		this.printadminId = printadminId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
