package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.LeaveLedgerDto;

import java.util.List;

public interface LeaveLedgerService {
    LeaveLedgerDto addLeaveLedger(LeaveLedgerDto leaveLedgerDto);

    List<LeaveLedgerDto> getAllLeaveRecords();

    LeaveLedgerDto getLeaveRecordById(int id);

    Integer getLeaveBalanceByEmployeeIdInLeaveLedger(long empId);

    List<LeaveLedgerDto> getLeaveLedgersWithLeaveApplication();

    List<LeaveLedgerDto> getLeaveLedgersWithCompensatoryLeave();

    LeaveLedgerDto updateLeaveLedger(int id, LeaveLedgerDto leaveLedgerDto);

    LeaveLedgerDto updateLeaveLedgerByLeaveRequestId(int id, LeaveLedgerDto leaveLedgerDto);

    LeaveLedgerDto updateLeaveLedgerByCompensatoryLeaveId(int id, LeaveLedgerDto leaveLedgerDto);

    List<LeaveLedgerDto> getAllLeaveLedgerByEmployeeId(long empId);

    String deleteLeaveLedgerById(int id);
}
