package com.gentech.erp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gentech.erp.hr.entity.LeaveLedger;

public interface LeaveLedgerRepository extends JpaRepository<LeaveLedger,Integer> {

    @Query("SELECT SUM(ll.leaveAccrued - ll.leaveUsed) FROM LeaveLedger ll WHERE ll.employee.empId = :empId")
    Integer getLeaveBalanceByEmployeeId(@Param("empId") long empId);

}