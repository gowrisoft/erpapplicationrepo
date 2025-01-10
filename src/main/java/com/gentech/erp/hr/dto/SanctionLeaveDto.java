package com.gentech.erp.hr.dto;

import com.gentech.erp.hr.entity.SanctionLeave.ApplicationStatus;
import java.time.LocalDateTime;

public class SanctionLeaveDto {
    private int sanctionId;
    private ApplicationStatus applicationStatus;
    private LocalDateTime sanctionDate;
    private Integer leaveRequestId; // Nullable
    private Integer compensatoryLeaveId; // Nullable
    private int adminId;

    public SanctionLeaveDto() {}

    public SanctionLeaveDto(int sanctionId, ApplicationStatus applicationStatus, LocalDateTime sanctionDate, Integer leaveRequestId, Integer compensatoryLeaveId, int adminId) {
        this.sanctionId = sanctionId;
        this.applicationStatus = applicationStatus;
        this.sanctionDate = sanctionDate;
        this.leaveRequestId = leaveRequestId;
        this.compensatoryLeaveId = compensatoryLeaveId;
        this.adminId = adminId;
    }

    public int getSanctionId() {
        return sanctionId;
    }

    public void setSanctionId(int sanctionId) {
        this.sanctionId = sanctionId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDateTime getSanctionDate() {
        return sanctionDate;
    }

    public void setSanctionDate(LocalDateTime sanctionDate) {
        this.sanctionDate = sanctionDate;
    }

    public Integer getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Integer leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Integer getCompensatoryLeaveId() {
        return compensatoryLeaveId;
    }

    public void setCompensatoryLeaveId(Integer compensatoryLeaveId) {
        this.compensatoryLeaveId = compensatoryLeaveId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}
