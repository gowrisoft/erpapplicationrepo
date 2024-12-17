package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.SanctionLeave;

public class SanctionLeaveMapper {
	public static SanctionLeaveDto mapSancToSancDto(SanctionLeave sanctionLeave){
        SanctionLeaveDto sanctionLeaveDto=new SanctionLeaveDto(
                sanctionLeave.getSanctionId(),
                sanctionLeave.getApplicationStatus(),
                sanctionLeave.getSanctionDate(),
                sanctionLeave.getLeaveApplication().getLeaveRequestId(),
                sanctionLeave.getAdmin().getAdminId()
        );
        return sanctionLeaveDto;
    }
    public static SanctionLeave mapSancDtoToSanc(SanctionLeaveDto sanctionLeaveDto, LeaveApplication leaveApplication, Admin admin){
        SanctionLeave sanctionLeave=new SanctionLeave(
                sanctionLeaveDto.getSanctionId(),
                sanctionLeaveDto.getApplicationStatus(),
                sanctionLeaveDto.getSanctionDate(),
                leaveApplication,
                admin
        );
        return sanctionLeave;
    }
}
