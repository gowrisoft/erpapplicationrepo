package com.gentech.erp.hr.service;

import java.util.List;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;

public interface PrintRelievingService {
	

	PrintRelievingReportsDto createPrintReports(PrintRelievingReportsDto printDto);
	
	List<PrintRelievingReportsDto> getAllPrintReports();

}
