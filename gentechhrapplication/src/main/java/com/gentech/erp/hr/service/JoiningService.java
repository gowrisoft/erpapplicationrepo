package com.gentech.erp.hr.service;

import java.util.List;
import com.gentech.erp.hr.dto.JoiningReportDto;

public interface JoiningService {
	
	JoiningReportDto createJoiningReport(JoiningReportDto joiningDto);
	
	List<JoiningReportDto> getAllJoiningReports();
	
}
