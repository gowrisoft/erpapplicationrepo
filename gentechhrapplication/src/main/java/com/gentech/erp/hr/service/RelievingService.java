package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.RelievingReportDto;

import java.util.List;

public interface RelievingService {

    RelievingReportDto createRelievingReport(RelievingReportDto relievingReportDto);

    List<RelievingReportDto> getAllRelievingReports();

}
