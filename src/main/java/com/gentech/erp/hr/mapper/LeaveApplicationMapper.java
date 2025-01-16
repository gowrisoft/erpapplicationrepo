package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.LeaveApplicationDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.SanctionLeave;

public class LeaveApplicationMapper {
    public static LeaveApplicationDto mapLeaveToLeaveDto(LeaveApplication leaveApplication) {
        LeaveApplicationDto leaveDto = new LeaveApplicationDto(
                leaveApplication.getLeaveRequestId(),
                leaveApplication.getStartDate(),
                leaveApplication.getEndDate(),
                leaveApplication.getReason(),
                leaveApplication.getTypeOfLeave(),
                leaveApplication.getStatus(),
                leaveApplication.getEmployee().getEmpId()
        );
        return leaveDto;
    }

    public static LeaveApplication mapLeaveDtoToLeave(LeaveApplicationDto leaveDto, Employee employee, SanctionLeave sanctionLeave) {
        LeaveApplication leaveApplication = new LeaveApplication(
                leaveDto.getLeaveRequestId(),
                leaveDto.getStartDate(),
                leaveDto.getEndDate(),
                leaveDto.getReason(),
                leaveDto.getTypeOfLeave(),
                leaveDto.getStatus(),
                employee,
                sanctionLeave,
                null
        );
        return leaveApplication;
    }
}
