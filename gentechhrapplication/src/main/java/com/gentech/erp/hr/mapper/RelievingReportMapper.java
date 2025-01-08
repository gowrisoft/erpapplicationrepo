package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.RelievingReportDto;
import com.gentech.erp.hr.entity.RelievingReport;

public class RelievingReportMapper {
    public static RelievingReportDto mapRelReportToRelReportDto(RelievingReport relievingReport) {
        RelievingReportDto relievingReportDto = new RelievingReportDto(
                relievingReport.getRelievingId(),
                relievingReport.getEmpName(),
                relievingReport.getDesignation(),
                relievingReport.getRelievingEmployee(),
                relievingReport.getReason(),
                relievingReport.getStatus(),
                relievingReport.getRelievingDate()
        );
        return relievingReportDto;
    }

    public static RelievingReport mapRelReportDtoToRelReport(RelievingReportDto relievingReportDto) {
        RelievingReport relievingReport = new RelievingReport(
                relievingReportDto.getRelievingId(),
                relievingReportDto.getEmpName(),
                relievingReportDto.getDesignation(),
                relievingReportDto.getRelievingEmployee(),
                relievingReportDto.getReason(),
                relievingReportDto.getStatus(),
                relievingReportDto.getRelievingDate()
        );
        return relievingReport;
    }
}
