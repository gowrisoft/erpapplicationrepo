package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.ModifyLeaveDto;

public interface ModifyLeaveService{
    ModifyLeaveDto addModifyLeave(ModifyLeaveDto modifyDto);
    List<ModifyLeaveDto> getAllModifiedLeaves();
    ModifyLeaveDto getModifyLeaveById(int id);
    String deleteModifyLeaveById(int id);
}
