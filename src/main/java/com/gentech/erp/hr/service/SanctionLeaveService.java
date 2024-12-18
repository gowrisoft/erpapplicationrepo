package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.SanctionLeaveDto;

public interface SanctionLeaveService {
    SanctionLeaveDto addSanctionLeave(SanctionLeaveDto sanctionLeaveDto);
    List<SanctionLeaveDto> getALlSanctionedLeaves();
    SanctionLeaveDto getSanctionLeaveById(int id);
    String deleteSanctionLeaveById(int id);
}
