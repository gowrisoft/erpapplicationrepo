package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.ApprovedMedicalClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovedMedicalClaimRepository extends JpaRepository<ApprovedMedicalClaim, Long> {
    @Query("SELECT a FROM ApprovedMedicalClaim a " +
            "JOIN a.medicalEntry m " +
            "JOIN m.dependant d " +
            "JOIN d.employee e " +
            "WHERE e.empId = :empId")
    List<ApprovedMedicalClaim> findByEmployeeEmpId(Long empId);

}
