package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;

import java.util.List;

public interface CompensatoryLeaveService {
    CompensatoryLeaveDto addCompensatoryLeave(CompensatoryLeaveDto compensatoryLeaveDto);

    List<CompensatoryLeaveDto> getAllCompensatoryLeaves();

    CompensatoryLeaveDto getAllCompensatoryLeaveById(int id);

    String deleteCompensatoryLeaveById(int id);

    CompensatoryLeaveDto updateCompensatoryLeave(int id,CompensatoryLeaveDto compensatoryLeaveDto);
}

