package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;

public interface RegisterRelievingService {

    RegisterRelievingReportsDto createRegisterReport(RegisterRelievingReportsDto registerDto);
	
	List<RegisterRelievingReportsDto> getAllRegisterReports();
	
}
