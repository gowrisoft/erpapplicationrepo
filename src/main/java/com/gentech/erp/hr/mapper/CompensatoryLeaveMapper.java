package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.Employee;

public class CompensatoryLeaveMapper {
    public static CompensatoryLeaveDto mapCompToCompDto(CompensatoryLeave compensatoryLeaveEntity) {
        CompensatoryLeaveDto compensatoryLeaveDto = new CompensatoryLeaveDto(
                compensatoryLeaveEntity.getCompensatoryLeaveId(),
                compensatoryLeaveEntity.getLeaveDate(),
                compensatoryLeaveEntity.getCompensatoryReason(),
                compensatoryLeaveEntity.getStartDate(),
                compensatoryLeaveEntity.getEndDate(),
                compensatoryLeaveEntity.getEmployee().getEmpId()
        );
        return compensatoryLeaveDto;
    }

    public static CompensatoryLeave mapCompDtoToComp(CompensatoryLeaveDto compensatoryLeaveDto, Employee employee) {
        CompensatoryLeave compensatoryLeaveEntity = new CompensatoryLeave(
                compensatoryLeaveDto.getCompensatoryLeaveId(),
                compensatoryLeaveDto.getLeaveDate(),
                compensatoryLeaveDto.getCompensatoryReason(),
                compensatoryLeaveDto.getStartDate(),
                compensatoryLeaveDto.getEndDate(),
                employee,
                null,
                null
        );
        return compensatoryLeaveEntity;
    }
}
