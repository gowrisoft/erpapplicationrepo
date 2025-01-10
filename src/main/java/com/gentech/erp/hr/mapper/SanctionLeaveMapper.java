package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.SanctionLeave;

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
                sanctionLeave.getAdmin().getAdminId()
        );
    }

    public static SanctionLeave mapSancDtoToSanc(SanctionLeaveDto sanctionLeaveDto, LeaveApplication leaveApplication, CompensatoryLeave compensatoryLeave, Admin admin) {
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
