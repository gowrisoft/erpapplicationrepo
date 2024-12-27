package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.LeaveLedgerDto;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.LeaveLedger;

public class LeaveLedgerMapper {
    public static LeaveLedgerDto mapLedgerToLedgerDto(LeaveLedger leaveLedger) {
        LeaveLedgerDto leaveLedgerDto = new LeaveLedgerDto(
                leaveLedger.getLedgerId(),
                leaveLedger.getLeaveAccrued(),
                leaveLedger.getDate(),
                leaveLedger.getLeaveType(),
                leaveLedger.getLeaveUsed(),
                leaveLedger.getLeaveBalance(),
                leaveLedger.getRemarks(),
                leaveLedger.getStatus(),
                leaveLedger.getProcessedBy(),
                leaveLedger.getEmployee().getEmpId(),
                leaveLedger.getLeaveApplication().getLeaveRequestId(),
                leaveLedger.getCompensatoryLeave().getCompensatoryLeaveId()
        );
        return leaveLedgerDto;
    }

    public static LeaveLedger mapLedgerDtoToLedger(LeaveLedgerDto leaveLedgerDto, Employee employee, LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeaveEntity) {
        LeaveLedger leaveLedger = new LeaveLedger(
                leaveLedgerDto.getLedgerId(),
                leaveLedgerDto.getLeaveAccrued(),
                leaveLedgerDto.getDate(),
                leaveLedgerDto.getLeaveType(),
                leaveLedgerDto.getLeaveUsed(),
                leaveLedgerDto.getLeaveBalance(),
                leaveLedgerDto.getRemarks(),
                leaveLedgerDto.getStatus(),
                leaveLedgerDto.getProcessedBy(),
                employee,
                leaveApplication,
                compensatoryLeaveEntity
        );
        return leaveLedger;
    }
}
