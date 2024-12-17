package com.gentech.erp.hr.dto;

public class AdminDto {
    public AdminDto(int adminId, String adminName, long adminPhone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPhone = adminPhone;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(long adminPhone) {
		this.adminPhone = adminPhone;
	}
	private int adminId;
    private String adminName;
    private long adminPhone;
}