package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovedMedicalClaimRepository extends JpaRepository<ApprovedMedicalClaim, Long> {
    List<ApprovedMedicalClaim> findByEmployee_EmpId(Long empId);
}
