package com.gentech.erp.hr.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.erp.hr.dto.RelievingReportDto;
import com.gentech.erp.hr.entity.RelievingReport;
import com.gentech.erp.hr.mapper.RelievingReportMapper;
import com.gentech.erp.hr.repository.RelievingRepository;
import com.gentech.erp.hr.service.RelievingService;

@Service
public class RelievingServiceImpl implements RelievingService{

	@Autowired
	private RelievingRepository relievingRepo;
	
	@Override
	public RelievingReportDto createRelievingReport(RelievingReportDto relievingDto) {
		RelievingReport relievingReport= RelievingReportMapper.mapRelReportDtoToRelReport(relievingDto);
		relievingRepo.save(relievingReport);
		return RelievingReportMapper.mapRelReportToRelReportDto(relievingReport);
	}

	@Override
	public List<RelievingReportDto> getAllRelievingReports() {
		return relievingRepo.findAll()
				.stream().map((relieving)->RelievingReportMapper.mapRelReportToRelReportDto(relieving))
				.toList();
	}

}
