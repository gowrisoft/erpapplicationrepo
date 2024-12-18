package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import com.gentech.erp.hr.dto.RegisterJoiningReportsDto;
import com.gentech.erp.hr.mapper.RegisterJoiningReportsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.erp.hr.entity.RegisterJoiningReports;
import com.gentech.erp.hr.repository.RegisterJoiningReportsRepository;
import com.gentech.erp.hr.service.RegisterJoiningReportsService;

@Service
public class RegisterJoiningReportsServiceImpl implements RegisterJoiningReportsService {

	@Autowired
	private RegisterJoiningReportsRepository registerRepo;

	@Override
	public RegisterJoiningReportsDto createRegisterReport(RegisterJoiningReportsDto registerDto) {
		RegisterJoiningReports registerJoiningReports= RegisterJoiningReportsMapper.mapRegJoinDtoToRegJoin(registerDto);
		registerRepo.save(registerJoiningReports);
		return RegisterJoiningReportsMapper.mapRegJoinToRegJoinDto(registerJoiningReports);
	}

	@Override
	public List<RegisterJoiningReportsDto> getAllRegisterReports() {
		return registerRepo.findAll()
				.stream().map((regJoining)->RegisterJoiningReportsMapper.mapRegJoinToRegJoinDto(regJoining))
				.toList();
	}
}
