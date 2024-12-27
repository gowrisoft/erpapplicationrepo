package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.SanctionLeaveDto;

import java.util.List;

public interface SanctionLeaveService {
    SanctionLeaveDto addSanctionLeave(SanctionLeaveDto sanctionLeaveDto);

    List<SanctionLeaveDto> getALlSanctionedLeaves();

    SanctionLeaveDto getSanctionLeaveById(int id);

    String deleteSanctionLeaveById(int id);
}
