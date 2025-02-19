package com.gentech.erp.hr.mapper;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import com.gentech.erp.hr.entity.PrintRelievingReports;

public class PrintRelievingReportsMapper {
    public static PrintRelievingReportsDto mapPrintRelToPrintRelDto(PrintRelievingReports printRelievingReports){
        PrintRelievingReportsDto printRelievingReportsDto = new PrintRelievingReportsDto(
                printRelievingReports.getPrintId(),
                printRelievingReports.getPrintDate(),
                printRelievingReports.getPrintRelievingId(),
                printRelievingReports.getPrintadminId(),// Ensure this field is included
                printRelievingReports.getPrintJoiningId(),
                printRelievingReports.getPrintempId(),
                printRelievingReports.getFirstName(),
                printRelievingReports.getLastName(),
                printRelievingReports.getStatus()
                
        );
        return printRelievingReportsDto;
    }

    public static PrintRelievingReports mapPrintRelDtoToPrintRel(PrintRelievingReportsDto printRelievingReportsDto){
        PrintRelievingReports printRelievingReports = new PrintRelievingReports(
                printRelievingReportsDto.getPrintId(),
                printRelievingReportsDto.getPrintDate(),
                printRelievingReportsDto.getPrintRelievingId(),
                printRelievingReportsDto.getPrintadminId(), // Make sure this is passed here
                printRelievingReportsDto.getPrintJoiningId(),
                printRelievingReportsDto.getPrintempId(),
                printRelievingReportsDto.getFirstName(),
                printRelievingReportsDto.getLastName(),
                printRelievingReportsDto.getStatus()
                
        );
        return printRelievingReports;
    }
}
