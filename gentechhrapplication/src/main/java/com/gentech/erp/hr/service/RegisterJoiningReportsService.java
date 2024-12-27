package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.RegisterJoiningReportsDto;

import java.util.List;


public interface RegisterJoiningReportsService {

    RegisterJoiningReportsDto createRegisterReport(RegisterJoiningReportsDto registerDto);

    List<RegisterJoiningReportsDto> getAllRegisterReports();

}
