package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Integer> {
    @Query("SELECT l.leaveRequestId FROM LeaveApplication l WHERE l.employee.empId = :empId")
    List<Integer> getLeaveIdByEmployeeId(@Param("empId") long empId);

    @Query("SELECT l FROM LeaveApplication l WHERE l.employee.empId = :empId")
    List<LeaveApplication> getLeavesByEmployeeId(@Param("empId") long empId);
}