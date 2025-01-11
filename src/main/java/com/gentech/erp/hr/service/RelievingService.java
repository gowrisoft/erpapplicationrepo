package com.gentech.erp.hr.service;

import java.util.List;
import com.gentech.erp.hr.dto.RelievingReportDto;


public interface RelievingService {

    RelievingReportDto createRelievingReport(RelievingReportDto relievingReportDto);

    List<RelievingReportDto> getAllRelievingReports();

    RelievingReportDto getRelievingReportById(Long id);

    RelievingReportDto updateRelievingReport(Long id,RelievingReportDto relievingDto);

    void deleteRelievingReportById(Long id);

}
