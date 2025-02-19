package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.LeaveLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LeaveLedgerRepository extends JpaRepository<LeaveLedger, Integer> {

    @Query("SELECT SUM(ll.leaveAccrued - ll.leaveUsed) FROM LeaveLedger ll WHERE ll.employee.empId = :empId")
    Integer getLeaveBalanceByEmployeeId(@Param("empId") long empId);

    @Query("SELECT l FROM LeaveLedger l WHERE l.employee.empId = :empId")
    List<LeaveLedger> getLeavesByEmployeeId(@Param("empId") long empId);

    @Query("SELECT ll FROM LeaveLedger ll WHERE ll.leaveApplication.leaveRequestId = :leaveRequestId")
    Optional<LeaveLedger> findByLeaveRequestId(@Param("leaveRequestId") Integer leaveRequestId);

    @Query("SELECT ll FROM LeaveLedger ll WHERE ll.compensatoryLeave.compensatoryLeaveId = :compensatoryLeaveId")
    Optional<LeaveLedger> findByCompensatoryLeaveId(@Param("compensatoryLeaveId") Integer compensatoryLeaveId);

    @Query("SELECT ll FROM LeaveLedger ll WHERE ll.leaveApplication.leaveRequestId IS NOT NULL")
    List<LeaveLedger> getLeaveLedgersWithLeaveRequestId();

    @Query("SELECT ll FROM LeaveLedger ll WHERE ll.compensatoryLeave.compensatoryLeaveId IS NOT NULL")
    List<LeaveLedger> getLeaveLedgersWithCompensatoryLeaveId();
}