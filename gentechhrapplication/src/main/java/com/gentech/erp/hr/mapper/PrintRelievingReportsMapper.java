package com.gentech.erp.hr.mapper;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import com.gentech.erp.hr.entity.PrintRelievingReports;

public class PrintRelievingReportsMapper {
    public static PrintRelievingReportsDto mapPrintRelToPrintRelDto(PrintRelievingReports printRelievingReports){
        PrintRelievingReportsDto printRelievingReportsDto = new PrintRelievingReportsDto(
                printRelievingReports.getPrintId(),
                printRelievingReports.getStatus(),
                printRelievingReports.getPrintDate(),
                printRelievingReports.getPrintRelievingId(),
                printRelievingReports.getPrintadminId() // Ensure this field is included
        );
        return printRelievingReportsDto;
    }

    public static PrintRelievingReports mapPrintRelDtoToPrintRel(PrintRelievingReportsDto printRelievingReportsDto){
        PrintRelievingReports printRelievingReports = new PrintRelievingReports(
                printRelievingReportsDto.getPrintId(),
                printRelievingReportsDto.getPrintDate(),
                printRelievingReportsDto.getPrintRelievingId(),
                printRelievingReportsDto.getPrintadminId(), // Make sure this is passed here
                printRelievingReportsDto.getStatus()
        );
        return printRelievingReports;
    }
}
