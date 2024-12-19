package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import com.gentech.erp.hr.service.MedicalApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medical-approval")
public class MedicalApproval {

    @Autowired
    private MedicalApprovalService medicalApprovalService;

    @PostMapping("/approve")
    public ResponseEntity<ApprovedMedicalClaim> approveMedicalEntry(@RequestParam("MRno") Long MRno, @RequestParam("approvedAmount") Double approvedAmount) {
        return ResponseEntity.ok(medicalApprovalService.approveMedicalEntry(MRno, approvedAmount));
    }
}
