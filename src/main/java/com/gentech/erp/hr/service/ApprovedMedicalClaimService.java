package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.ApprovedMedicalClaimDto;

import java.util.List;

public interface ApprovedMedicalClaimService {

    ApprovedMedicalClaimDto approveMedicalEntry(Long MedicalEntryId, Double approvedAmount, Long adminId);

    List<ApprovedMedicalClaimDto> getApprovedMedicalClaimByEmployeeId(Long empId);

    ApprovedMedicalClaimDto getApprovedMedicalClaimById(Long claimId);

    List<ApprovedMedicalClaimDto> getAllApprovedMedicalClaims();
}
