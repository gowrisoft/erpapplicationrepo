package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.PrintRelievingReportsDto;

import java.util.List;

public interface PrintRelievingService {


    PrintRelievingReportsDto createPrintReports(PrintRelievingReportsDto printDto);

    List<PrintRelievingReportsDto> getAllPrintReports();

}
