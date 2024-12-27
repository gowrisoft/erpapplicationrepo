package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.JoiningReportDto;

import java.util.List;

public interface JoiningService {

    JoiningReportDto createJoiningReport(JoiningReportDto joiningDto);

    List<JoiningReportDto> getAllJoiningReports();

}
