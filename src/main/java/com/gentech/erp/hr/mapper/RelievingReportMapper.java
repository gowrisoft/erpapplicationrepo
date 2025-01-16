package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.RelievingReportDto;
import com.gentech.erp.hr.entity.RelievingReport;

public class RelievingReportMapper {
    public static RelievingReportDto mapRelReportToRelReportDto(RelievingReport relievingReport){
        RelievingReportDto relievingReportDto=new RelievingReportDto(
                relievingReport.getRelievingId(),
                relievingReport.getFirstName(),
                relievingReport.getLastName(),
                relievingReport.getDesignation(),
                relievingReport.getRelievingEmployee(),
                relievingReport.getReladminId(),
                relievingReport.getRelJoiningId(),
                relievingReport.getReason(),
                relievingReport.getStatus(),
                relievingReport.getRelievingDate()
              
                
        );
        return relievingReportDto;
    }
    public static RelievingReport mapRelReportDtoToRelReport(RelievingReportDto relievingReportDto){
        RelievingReport relievingReport=new RelievingReport(
        		relievingReportDto.getRelievingId(),
                relievingReportDto.getFirstName(),
                relievingReportDto.getLastName(),
                relievingReportDto.getDesignation(),
                relievingReportDto.getRelievingEmployee(),
                relievingReportDto.getReladminId(),
                relievingReportDto.getRelJoiningId(),
                relievingReportDto.getReason(),
                relievingReportDto.getStatus(),
                relievingReportDto.getRelievingDate()
        );
        return relievingReport;
    }
}
