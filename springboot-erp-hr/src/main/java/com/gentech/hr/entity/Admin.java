package com.gentech.hr.entity;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	@Column(name = "admin_name")
	private String adminName;
	@Column(name = "admin_contact")
	private String admin_contact;
	
	public Admin()
	{
		
	}

	public Admin(String adminName, String admin_contact) {
		super();
		this.adminName = adminName;
		this.admin_contact = admin_contact;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdmin_contact() {
		return admin_contact;
	}

	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}

	
}
