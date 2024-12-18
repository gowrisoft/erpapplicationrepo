package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.RegisterJoiningReportsDto;


public interface RegisterJoiningReportsService {

    RegisterJoiningReportsDto createRegisterReport(RegisterJoiningReportsDto registerDto);
	
	List<RegisterJoiningReportsDto> getAllRegisterReports();
	
}
