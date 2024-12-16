package com.gentech.hr.service;

import java.util.List;
import com.gentech.hr.entity.RelievingReport;

public interface RelievingService {
	
	RelievingReport createRelievingReport( RelievingReport relieving);
	
	List<RelievingReport> getAllRelievingReports();

}
