package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.RelievingReportDto;

public interface RelievingService {
	
	RelievingReportDto createRelievingReport(RelievingReportDto relievingReportDto);
	
	List<RelievingReportDto> getAllRelievingReports();

}
