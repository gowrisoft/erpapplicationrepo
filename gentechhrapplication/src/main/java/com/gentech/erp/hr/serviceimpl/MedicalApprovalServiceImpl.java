package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import com.gentech.erp.hr.entity.MedicalEntries;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.ApprovedMedicalClaimRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.MedicalEntriesRepository;
import com.gentech.erp.hr.service.MedicalApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MedicalApprovalServiceImpl implements MedicalApprovalService {

    @Autowired
    private MedicalEntriesRepository medicalEntriesRepository;

    @Autowired
    private ApprovedMedicalClaimRepository approvedMedicalClaimRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ApprovedMedicalClaim approveMedicalEntry(Long MRno, Double approvedAmount) {
        MedicalEntries medicalEntry = medicalEntriesRepository.findById(MRno)
                .orElseThrow(() -> new ResourceNotFoundException("Medical entry not found with MRno: " + MRno));
        ApprovedMedicalClaim approvedClaim = new ApprovedMedicalClaim();
        approvedClaim.setMedicalEntry(medicalEntry);
        approvedClaim.setApprovedAmount(approvedAmount);
        approvedClaim.setApprovalDate(LocalDate.now());

        return approvedMedicalClaimRepository.save(approvedClaim);
    }
}
