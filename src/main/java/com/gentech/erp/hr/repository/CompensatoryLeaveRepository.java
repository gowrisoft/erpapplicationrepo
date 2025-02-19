package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompensatoryLeaveRepository extends JpaRepository<CompensatoryLeave, Integer> {

    @Query("SELECT c FROM CompensatoryLeave c WHERE c.employee.empId = :empId")
    List<CompensatoryLeave> getCompensatoryLeavesByEmployeeId(@Param("empId") long empId);
}