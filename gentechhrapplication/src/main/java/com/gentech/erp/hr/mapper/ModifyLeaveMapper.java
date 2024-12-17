package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.ModifyLeaveDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.ModifyLeave;

public class ModifyLeaveMapper {
	public static ModifyLeaveDto mapModifyToModifyDto(ModifyLeave modifyLeave){
        ModifyLeaveDto modifyDto=new ModifyLeaveDto(
                modifyLeave.getModifyLeaveId(),
                modifyLeave.getEmpName(),
                modifyLeave.getModifiedDate(),
                modifyLeave.getNewStartDate(),
                modifyLeave.getNewEndDate(),
                modifyLeave.getNewLeaveType(),
                modifyLeave.getEmployee().getEmpId(),
                modifyLeave.getLeaveApplication().getLeaveRequestId()
        );
        return modifyDto;
    }
    public static ModifyLeave mapModifyDtoToModify(ModifyLeaveDto modifyDto, Employee employee, LeaveApplication leaveApplication){
        ModifyLeave modifyLeave=new ModifyLeave(
                modifyDto.getModifyLeaveId(),
                modifyDto.getEmpName(),
                modifyDto.getModifiedDate(),
                modifyDto.getNewStartDate(),
                modifyDto.getNewEndDate(),
                modifyDto.getNewLeaveType(),
                employee,
                leaveApplication
        );
        return modifyLeave;
    }
}
