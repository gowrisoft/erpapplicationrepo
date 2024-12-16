package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.hr.entity.RegisterJoiningReports;
import com.gentech.hr.repository.RegisterJoiningReportsRepository;
import com.gentech.hr.service.RegisterJoiningReportsService;

@Service
public class RegisterJoiningReportsServiceImpl implements RegisterJoiningReportsService {

	@Autowired
	private RegisterJoiningReportsRepository registerRepo;

	@Override
	public RegisterJoiningReports createRegisterReport(RegisterJoiningReports register) {
		return registerRepo.save(register);
	}

	@Override
	public List<RegisterJoiningReports> getAllRegisterReports() {
		return registerRepo.findAll();
	}
}
