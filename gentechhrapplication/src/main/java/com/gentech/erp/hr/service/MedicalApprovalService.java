package com.gentech.erp.hr.service;

import com.gentech.erp.hr.entity.ApprovedMedicalClaim;

public interface MedicalApprovalService {
    ApprovedMedicalClaim approveMedicalEntry(Long MRno, Double approvedAmount);
}
