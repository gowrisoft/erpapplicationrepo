package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.PrintJoiningReportsDto;

import java.util.List;


public interface PrintJoiningReportsService {

    PrintJoiningReportsDto createPrintReports(PrintJoiningReportsDto printDto);

    List<PrintJoiningReportsDto> getAllPrintReportss();

}
