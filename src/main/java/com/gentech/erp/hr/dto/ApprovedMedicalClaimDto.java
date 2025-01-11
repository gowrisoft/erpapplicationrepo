package com.gentech.erp.hr.dto;

import java.time.LocalDate;

public class ApprovedMedicalClaimDto {

    private Long claimId;
    private Long medicalEntryId;
    private Double approvedAmount;
    private LocalDate approvalDate;
    private Long adminId;

    public ApprovedMedicalClaimDto() {
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Long getMedicalEntryId() {
        return medicalEntryId;
    }

    public void setMedicalEntryId(Long medicalEntryId) {
        this.medicalEntryId = medicalEntryId;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
