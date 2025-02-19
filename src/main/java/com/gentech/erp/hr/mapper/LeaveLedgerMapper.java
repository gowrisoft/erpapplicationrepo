package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.LeaveLedgerDto;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.LeaveLedger;

public class LeaveLedgerMapper {
    public static LeaveLedgerDto mapLedgerToLedgerDto(LeaveLedger leaveLedger) {
        // Add null-safety checks
        Integer leaveRequestId = leaveLedger.getLeaveApplication() != null
                ? leaveLedger.getLeaveApplication().getLeaveRequestId()
                : null;
        Integer compensatoryLeaveId = leaveLedger.getCompensatoryLeave() != null
                ? leaveLedger.getCompensatoryLeave().getCompensatoryLeaveId()
                : null;

        // Create and return the DTO
        return new LeaveLedgerDto(
                leaveLedger.getLedgerId(),
                leaveLedger.getLeaveAccrued(),
                leaveLedger.getLeaveType(),
                leaveLedger.getLeaveUsed(),
                leaveLedger.getLeaveBalance(),
                leaveLedger.getStatus(),
                leaveLedger.getProcessedBy(),
                leaveLedger.getEmployee().getEmpId(),
                leaveRequestId,
                compensatoryLeaveId
        );
    }

    public static LeaveLedger mapLedgerDtoToLedger(LeaveLedgerDto leaveLedgerDto, Employee employee,
                                                   LeaveApplication leaveApplication,
                                                   CompensatoryLeave compensatoryLeaveEntity) {
        LeaveLedger leaveLedger = new LeaveLedger(
                leaveLedgerDto.getLedgerId(),
                leaveLedgerDto.getLeaveAccrued() != null ? leaveLedgerDto.getLeaveAccrued() : 100, // Pass null if no value provided
                leaveLedgerDto.getLeaveType(),
                leaveLedgerDto.getLeaveUsed(),
                leaveLedgerDto.getLeaveBalance(),
                leaveLedgerDto.getStatus(),
                leaveLedgerDto.getProcessedBy(),
                employee,
                leaveApplication,
                compensatoryLeaveEntity
        );
        return leaveLedger;
    }

}
