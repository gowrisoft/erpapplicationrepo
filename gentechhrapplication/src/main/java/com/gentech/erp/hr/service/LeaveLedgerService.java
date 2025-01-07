package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.LeaveLedgerDto;

import java.util.List;

public interface LeaveLedgerService {
    LeaveLedgerDto addLeaveLedger(LeaveLedgerDto leaveLedgerDto);

    List<LeaveLedgerDto> getAllLeaveRecords();

    LeaveLedgerDto getLeaveRecordById(int id);

    Integer getLeaveBalanceByEmployeeIdInLeaveLedger(long empId);

    String deleteLeaveLedgerById(int id);
}
