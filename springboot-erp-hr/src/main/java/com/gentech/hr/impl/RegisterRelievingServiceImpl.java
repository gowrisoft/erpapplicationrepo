package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.RegisterRelievingReports;
import com.gentech.hr.repository.RegisterRelievingRepository;

import com.gentech.hr.service.RegisterRelievingService;


@Service
public class RegisterRelievingServiceImpl implements RegisterRelievingService {

	@Autowired
	private RegisterRelievingRepository registerRepo;

	@Override
	public RegisterRelievingReports createRegisterReport(RegisterRelievingReports register) {
		return registerRepo.save(register);
	}

	@Override
	public List<RegisterRelievingReports> getAllRegisterReports() {
		return registerRepo.findAll();
	}
}
