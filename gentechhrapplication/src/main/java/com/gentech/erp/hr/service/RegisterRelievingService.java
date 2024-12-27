package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;

import java.util.List;

public interface RegisterRelievingService {

    RegisterRelievingReportsDto createRegisterReport(RegisterRelievingReportsDto registerDto);

    List<RegisterRelievingReportsDto> getAllRegisterReports();

}
