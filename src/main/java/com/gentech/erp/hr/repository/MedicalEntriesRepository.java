package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.MedicalEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MedicalEntriesRepository extends JpaRepository<MedicalEntries, Long> {

    List<MedicalEntries> findAllByDependant_Employee_EmpId(Long dependantEmployeeEmpId);

    List<MedicalEntries> findAllByStatus(MedicalEntries.MedicalEntryStatus status);
}
