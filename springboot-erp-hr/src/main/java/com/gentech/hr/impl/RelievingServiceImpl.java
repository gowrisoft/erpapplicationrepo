package com.gentech.hr.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.hr.entity.RelievingReport;
import com.gentech.hr.repository.RelievingRepository;
import com.gentech.hr.service.RelievingService;
@Service
public class RelievingServiceImpl implements RelievingService{

	@Autowired
	private RelievingRepository relievingRepo;
	
	@Override
	public RelievingReport createRelievingReport(RelievingReport relieving) {
		return relievingRepo.save(relieving);
	}

	@Override
	public List<RelievingReport> getAllRelievingReports() {
		return relievingRepo.findAll();
	}

}
