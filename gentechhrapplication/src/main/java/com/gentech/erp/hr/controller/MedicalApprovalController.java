package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.ApprovedMedicalClaimDto;
import com.gentech.erp.hr.service.MedicalApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/v1/api/medical-approval")
public class MedicalApprovalController {

    @Autowired
    private MedicalApprovalService medicalApprovalService;

    @PostMapping("/")
    public ResponseEntity<ApprovedMedicalClaimDto> approveMedicalEntry(@RequestParam("medicalEntryId") Long medicalEntryId, @RequestParam("approvedAmount") Double approvedAmount) {
        return ResponseEntity.ok(medicalApprovalService.approveMedicalEntry(medicalEntryId, approvedAmount));
    }

    @GetMapping("/empId/{empId}")
    public ResponseEntity<List<ApprovedMedicalClaimDto>> getApprovedMedicalClaimByEmployeeId(@PathVariable Long empId) {
        return ResponseEntity.ok(medicalApprovalService.getApprovedMedicalClaimByEmployeeId(empId));
    }

    @GetMapping("/claimId/{claimId}")
    public ResponseEntity<ApprovedMedicalClaimDto> getApprovedMedicalClaimById(@PathVariable Long claimId) {
        return ResponseEntity.ok(medicalApprovalService.getApprovedMedicalClaimById(claimId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ApprovedMedicalClaimDto>> getAllApprovedMedicalClaims() {
        return ResponseEntity.ok(medicalApprovalService.getAllApprovedMedicalClaims());
    }
}