package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.JoiningReportDto;
import com.gentech.erp.hr.entity.JoiningReport;

public class JoiningReportMapper {
    public static JoiningReportDto mapJoinToJoinDto(JoiningReport joiningReport){
        JoiningReportDto joiningReportDto=new JoiningReportDto(
                joiningReport.getJoiningId(),
                joiningReport.getFirstName(),
                joiningReport.getLastName(),
                joiningReport.getDesignation(),
                joiningReport.getStatus(),
                joiningReport.getDateOfJoining(),
                joiningReport.getJoiningEmployee(),
                joiningReport.getJoinadminId(),
                joiningReport.getReportingManager()
                
        );
        return joiningReportDto;//here order of DTO layer matters
    }
    public static JoiningReport mapJoinDtoToJoin(JoiningReportDto joiningReportDto){
        JoiningReport joiningReport=new JoiningReport(
                joiningReportDto.getJoiningId(),
                joiningReportDto.getFirstName(),
                joiningReportDto.getLastName(),
                joiningReportDto.getDesignation(),
                joiningReportDto.getStatus(),
                joiningReportDto.getDateOfJoining(),
                joiningReportDto.getJoiningEmployee(),
                joiningReportDto.getJoinadminId(),
                joiningReportDto.getReportingManager()
                
        );
        return joiningReport;//here order of Entity layer matters
    }
}
