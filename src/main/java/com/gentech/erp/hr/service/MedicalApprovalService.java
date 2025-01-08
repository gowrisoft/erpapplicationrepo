package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.ApprovedMedicalClaimDto;

import java.util.List;

public interface MedicalApprovalService {
    ApprovedMedicalClaimDto approveMedicalEntry(Long MRno, Double approvedAmount);

    List<ApprovedMedicalClaimDto> getApprovedMedicalClaimByEmployeeId(Long empId);

    ApprovedMedicalClaimDto getApprovedMedicalClaimById(Long claimId);

    List<ApprovedMedicalClaimDto> getAllApprovedMedicalClaims();
}
