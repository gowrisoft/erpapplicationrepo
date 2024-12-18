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
@Table(name = "tbl_register_joining_report")
public class RegisterJoiningReports{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "register_id")
    private Long registerId;

    @Column(name = "record_date")
    private Date recordDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_joining_id", referencedColumnName = "joining_id")
    private JoiningReport regJoiningId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verified_by_adminid", referencedColumnName = "admin_id")
    private Admin verifiedByAdminId;
    
    public RegisterJoiningReports()
    {
    	
    }
    
	public RegisterJoiningReports(Long registerId, Date recordDate, JoiningReport regJoiningId, Admin verifiedByAdminId) {
		this.registerId = registerId;
		this.recordDate = recordDate;
		this.regJoiningId = regJoiningId;
		this.verifiedByAdminId = verifiedByAdminId;
	}

	public RegisterJoiningReports(Date recordDate, JoiningReport regJoiningId, Admin verifiedByAdminId) {
		super();
		this.recordDate = recordDate;
		this.regJoiningId = regJoiningId;
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

	public JoiningReport getRegJoiningId() {
		return regJoiningId;
	}

	public void setRegJoiningId(JoiningReport regJoiningId) {
		this.regJoiningId = regJoiningId;
	}

	public Admin getverifiedByAdminId() {
		return verifiedByAdminId;
	}

	public void setverifiedByAdminId(Admin verifiedby) {
		this.verifiedByAdminId = verifiedby;
	}

}
