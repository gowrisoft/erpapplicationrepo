package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.PrintJoiningReportsDto;
import com.gentech.erp.hr.entity.PrintJoiningReports;

public class PrintJoiningReportsMapper {
    public static PrintJoiningReportsDto mapPrintJoinToPrintJoinDto(PrintJoiningReports printJoiningReports){
        PrintJoiningReportsDto printJoiningReportsDto = new PrintJoiningReportsDto(
                printJoiningReports.getPrintId(),
                printJoiningReports.getStatus(),
                printJoiningReports.getPrintDate(),
                printJoiningReports.getPrintJoiningId(),
                printJoiningReports.getPrintadminId(),
                printJoiningReports.getPrintempId(),
                printJoiningReports.getEmpName()


        );
        return printJoiningReportsDto;
    }

    public static PrintJoiningReports mapPrintJoinDtoToPrintJoin(PrintJoiningReportsDto printJoiningReportsDto){
        PrintJoiningReports printJoiningReports = new PrintJoiningReports(
                printJoiningReportsDto.getPrintId(),
                printJoiningReportsDto.getPrintDate(),
                printJoiningReportsDto.getPrintJoiningId(),
                printJoiningReportsDto.getPrintadminId() ,
                printJoiningReportsDto.getStatus(),
                printJoiningReportsDto.getPrintempId(),
                printJoiningReportsDto.getEmpName()
        );
        return printJoiningReports;
    }
}
