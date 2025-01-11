package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.entity.*;

public class SanctionLeaveMapper {
    public static SanctionLeaveDto mapSancToSancDto(SanctionLeave sanctionLeave) {
        Integer leaveRequestId = sanctionLeave.getLeaveApplication() != null
                ? sanctionLeave.getLeaveApplication().getLeaveRequestId()
                : null;
        Integer compensatoryLeaveId = sanctionLeave.getCompensatoryLeave() != null
                ? sanctionLeave.getCompensatoryLeave().getCompensatoryLeaveId()
                : null;

        return new SanctionLeaveDto(
                sanctionLeave.getSanctionId(),
                sanctionLeave.getApplicationStatus(),
                sanctionLeave.getSanctionDate(),
                leaveRequestId,
                compensatoryLeaveId,
                sanctionLeave.getAdmin().getEmpId()
        );
    }

    public static SanctionLeave mapSancDtoToSanc(SanctionLeaveDto sanctionLeaveDto, LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeave, Employee admin) {
        return new SanctionLeave(
                sanctionLeaveDto.getSanctionId(),
                sanctionLeaveDto.getApplicationStatus(),
                sanctionLeaveDto.getSanctionDate(),
                leaveApplication,
                compensatoryLeave,
                admin
        );
    }
}
