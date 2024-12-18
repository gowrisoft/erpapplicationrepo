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
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_register_relieving_report")
public class RegisterRelievingReports{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "register_id")
    private Long registerId;

    @Column(name = "record_date")
    private Date recordDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_relieving_id", referencedColumnName = "relieving_id")
    private RelievingReport regRelievingId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verified_by_adminid", referencedColumnName = "admin_id")
    private Admin verifiedByAdminId;
    
    public RegisterRelievingReports()
    {
    	
    }

	public RegisterRelievingReports(Long registerId, Date recordDate, RelievingReport regRelievingId, Admin verifiedByAdminId) {
		this.registerId = registerId;
		this.recordDate = recordDate;
		this.regRelievingId = regRelievingId;
		this.verifiedByAdminId = verifiedByAdminId;
	}

	public RegisterRelievingReports(Date recordDate, RelievingReport regRelievingId, Admin verifiedByAdminId) {
		super();
		this.recordDate = recordDate;
		this.regRelievingId = regRelievingId;
		this.verifiedByAdminId = verifiedByAdminId;
	}

	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public RelievingReport getregRelievingId() {
		return regRelievingId;
	}

	public void setRegrelievingId(RelievingReport regRelievingId) {
		this.regRelievingId = regRelievingId;
	}

	public Admin getverifiedByAdminId() {
		return verifiedByAdminId;
	}

	public void setverifiedByAdminId(Admin verifiedby) {
		this.verifiedByAdminId = verifiedby;
	}

}
