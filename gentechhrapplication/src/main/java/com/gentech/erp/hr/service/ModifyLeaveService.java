package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.ModifyLeaveDto;

import java.util.List;

public interface ModifyLeaveService {
    ModifyLeaveDto addModifyLeave(ModifyLeaveDto modifyDto);

    List<ModifyLeaveDto> getAllModifiedLeaves();

    ModifyLeaveDto getModifyLeaveById(int id);

    String deleteModifyLeaveById(int id);
}
