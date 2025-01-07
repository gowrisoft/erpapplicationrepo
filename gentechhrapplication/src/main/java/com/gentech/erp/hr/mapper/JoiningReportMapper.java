package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.JoiningReportDto;
import com.gentech.erp.hr.entity.JoiningReport;

public class JoiningReportMapper {
    public static JoiningReportDto mapJoinToJoinDto(JoiningReport joiningReport) {
        JoiningReportDto joiningReportDto = new JoiningReportDto(
                joiningReport.getJoiningId(),
                joiningReport.getEmpName(),
                joiningReport.getDesignation(),
                joiningReport.getStatus(),
                joiningReport.getJoiningDate(),
                joiningReport.getJoiningEmployee(),
                joiningReport.getReportingManagerId()

        );
        return joiningReportDto;//here order of DTO layer matters
    }

    public static JoiningReport mapJoinDtoToJoin(JoiningReportDto joiningReportDto) {
        JoiningReport joiningReport = new JoiningReport(
                joiningReportDto.getJoiningId(),
                joiningReportDto.getEmpName(),
                joiningReportDto.getDesignation(),
                joiningReportDto.getStatus(),
                joiningReportDto.getJoiningDate(),
                joiningReportDto.getJoiningEmployee(),
                joiningReportDto.getReportingManagerId()
        );
        return joiningReport;//here order of Entity layer matters
    }
}
