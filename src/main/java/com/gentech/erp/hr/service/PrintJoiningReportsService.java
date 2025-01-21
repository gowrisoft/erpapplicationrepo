package com.gentech.erp.hr.service;

import java.util.List;
import com.gentech.erp.hr.dto.PrintJoiningReportsDto;


public interface PrintJoiningReportsService {

    PrintJoiningReportsDto createPrintReports(PrintJoiningReportsDto printDto);

    List<PrintJoiningReportsDto> getAllPrintReportss();

    PrintJoiningReportsDto getPrintJoiningReportById(Long id);

    PrintJoiningReportsDto updatePrintJoiningReport(Long id,PrintJoiningReportsDto printDto);

    void deletePrintJoiningReportById(Long id);
    
    List<PrintJoiningReportsDto> getPrintJoiningReportByEmpId(Long employeeId);

}
