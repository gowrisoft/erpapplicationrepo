package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;

public interface CompensatoryLeaveService {
    CompensatoryLeaveDto addCompensatoryLeave(CompensatoryLeaveDto compensatoryLeaveDto);
    List<CompensatoryLeaveDto> getAllCompensatoryLeaves();
    CompensatoryLeaveDto getAllCompensatoryLeaveById(int id);
    String deleteCompensatoryLeaveById(int id);
}

