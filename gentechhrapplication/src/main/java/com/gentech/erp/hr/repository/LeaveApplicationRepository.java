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

    @Query(value = "SELECT DISTINCT " +
            "COALESCE(m.modify_leave_id, l.leave_req_id) AS leaveRequestId, " +
            "COALESCE(m.emp_name, l.emp_name) AS empName, " +
            "COALESCE(m.new_end_date, l.end_date) AS endDate, " +
            "COALESCE(m.new_leave_type, l.type_of_leave) AS leaveType, " +
            "COALESCE(m.new_start_date, l.start_date) AS startDate, " +
            "COALESCE(m.emp_id, l.emp_id) AS empId, " +
            "COALESCE(m.new_reason, l.reason) AS reason " +
            "FROM apply_leave l " +
            "LEFT JOIN modify_leave m ON l.leave_req_id = m.leave_req_id " +
            "UNION " +
            "SELECT " +
            "l.leave_req_id AS leaveRequestId, " +
            "l.emp_name AS empName, " +
            "l.end_date AS endDate, " +
            "l.type_of_leave AS leaveType, " +
            "l.start_date AS startDate, " +
            "l.emp_id AS empId, " +
            "l.reason AS reason " +
            "FROM apply_leave l " +
            "WHERE NOT EXISTS (SELECT 1 FROM modify_leave m WHERE l.leave_req_id = m.leave_req_id)",
            nativeQuery = true)
    List<Object[]> getLeaveDetails();
}