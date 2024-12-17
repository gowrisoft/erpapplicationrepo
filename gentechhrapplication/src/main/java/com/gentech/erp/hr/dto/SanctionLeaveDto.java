package com.gentech.erp.hr.dto;

import java.time.LocalDateTime;

import com.gentech.erp.hr.entity.SanctionLeave;
import com.gentech.erp.hr.entity.SanctionLeave.ApplicationStatus;

public class SanctionLeaveDto {
	public SanctionLeaveDto(int sanctionId, ApplicationStatus applicationStatus, LocalDateTime sanctionDate,
			int leaveRequestId, int adminId) {
		super();
		this.sanctionId = sanctionId;
		this.applicationStatus = applicationStatus;
		this.sanctionDate = sanctionDate;
		this.leaveRequestId = leaveRequestId;
		this.adminId = adminId;
	}
	public int getSanctionId() {
		return sanctionId;
	}
	public void setSanctionId(int sanctionId) {
		this.sanctionId = sanctionId;
	}
	public SanctionLeave.ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(SanctionLeave.ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public LocalDateTime getSanctionDate() {
		return sanctionDate;
	}
	public void setSanctionDate(LocalDateTime sanctionDate) {
		this.sanctionDate = sanctionDate;
	}
	public int getLeaveRequestId() {
		return leaveRequestId;
	}
	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	private int sanctionId;
    private SanctionLeave.ApplicationStatus applicationStatus;
    private LocalDateTime sanctionDate;
    private int leaveRequestId;
    private int adminId;
}
