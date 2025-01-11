package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.ApprovedMedicalClaimDto;
import com.gentech.erp.hr.service.ApprovedMedicalClaimService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/medical-approval")
public class ApprovedMedicalClaimController {

    @Autowired
    private ApprovedMedicalClaimService approvedMedicalClaimService;

    @PostMapping("/")
    public ResponseEntity<ApprovedMedicalClaimDto> approveMedicalEntry(@RequestParam("medicalEntryId") Long medicalEntryId, @RequestParam("approvedAmount") Double approvedAmount, HttpServletRequest request) {
        return ResponseEntity.ok(approvedMedicalClaimService.approveMedicalEntry(
                medicalEntryId, approvedAmount, (Long) request.getAttribute("employeeId")));
    }

    @GetMapping("/empId/{empId}")
    public ResponseEntity<List<ApprovedMedicalClaimDto>> getApprovedMedicalClaimByEmployeeId(@PathVariable Long empId) {
        return ResponseEntity.ok(approvedMedicalClaimService.getApprovedMedicalClaimByEmployeeId(empId));
    }

    @GetMapping("/claimId/{claimId}")
    public ResponseEntity<ApprovedMedicalClaimDto> getApprovedMedicalClaimById(@PathVariable Long claimId) {
        return ResponseEntity.ok(approvedMedicalClaimService.getApprovedMedicalClaimById(claimId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ApprovedMedicalClaimDto>> getAllApprovedMedicalClaims() {
        return ResponseEntity.ok(approvedMedicalClaimService.getAllApprovedMedicalClaims());
    }
}