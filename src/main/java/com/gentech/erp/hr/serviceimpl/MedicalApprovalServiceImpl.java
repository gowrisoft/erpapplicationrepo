package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.ApprovedMedicalClaimDto;
import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import com.gentech.erp.hr.entity.MedicalEntries;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.ApprovedMedicalClaimRepository;
import com.gentech.erp.hr.repository.MedicalEntriesRepository;
import com.gentech.erp.hr.service.MedicalApprovalService;
import com.gentech.erp.hr.service.MedicalEntriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicalApprovalServiceImpl implements MedicalApprovalService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private MedicalEntriesRepository medicalEntriesRepository;
    @Autowired
    private ApprovedMedicalClaimRepository approvedMedicalClaimRepository;
    @Autowired
    private MedicalEntriesService MedicalEntriesService;

    @Override
    public ApprovedMedicalClaimDto approveMedicalEntry(Long MedicalEntryId, Double approvedAmount) {
        MedicalEntries medicalEntry = medicalEntriesRepository.findById(MedicalEntryId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical entry not found with MedicalEntryId: " + MedicalEntryId));
        ApprovedMedicalClaim approvedClaim = new ApprovedMedicalClaim();
        approvedClaim.setMedicalEntry(medicalEntry);
        approvedClaim.setApprovedAmount(approvedAmount);
        approvedClaim.setApprovalDate(LocalDate.now());
        MedicalEntriesService.updateMedicalEntryStatus(MedicalEntryId, "APPROVED");
        return modelMapper.map(approvedMedicalClaimRepository.save(approvedClaim), ApprovedMedicalClaimDto.class);
    }

    @Override
    public List<ApprovedMedicalClaimDto> getApprovedMedicalClaimByEmployeeId(Long empId) {
        List<ApprovedMedicalClaim> approvedMedicalClaims = approvedMedicalClaimRepository.findByEmployeeEmpId(empId);
        return approvedMedicalClaims.stream().map(approvedMedicalClaim -> modelMapper.map
                (approvedMedicalClaim, ApprovedMedicalClaimDto.class)).toList();
    }

    @Override
    public ApprovedMedicalClaimDto getApprovedMedicalClaimById(Long claimId) {
        return modelMapper.map(approvedMedicalClaimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Approved Medical Claim not found with id: " + claimId)), ApprovedMedicalClaimDto.class);
    }

    @Override
    public List<ApprovedMedicalClaimDto> getAllApprovedMedicalClaims() {
        return approvedMedicalClaimRepository.findAll().stream().map(approvedMedicalClaim -> modelMapper.map
                (approvedMedicalClaim, ApprovedMedicalClaimDto.class)).toList();
    }
}