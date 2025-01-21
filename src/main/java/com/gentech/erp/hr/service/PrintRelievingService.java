package com.gentech.erp.hr.service;

import java.util.List;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;

public interface PrintRelievingService {


    PrintRelievingReportsDto createPrintReports(PrintRelievingReportsDto printDto);

    List<PrintRelievingReportsDto> getAllPrintReports();

    PrintRelievingReportsDto getPrintRelievingReportById(Long id);

    PrintRelievingReportsDto updatePrintRelievingReport(Long id,PrintRelievingReportsDto printDto);

    void deletePrintRelievingReportById(Long id);
    
    List<PrintRelievingReportsDto> getPrintRelievingReportByEmpId(Long employeeId);

}
