package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.BiometricPunchingReport;
import com.gentech.hr.repository.BiometricPunchingReportRepository;
import com.gentech.hr.service.BiometricPunchingReportService;

@Service
public class BiometricPunchingReportServiceImpl implements BiometricPunchingReportService{

	@Autowired
	private BiometricPunchingReportRepository biometricpunchingreportRepo;
	
	@Override
	public BiometricPunchingReport createBiometricPunchingReport(BiometricPunchingReport biometricpunchingreport) {
		return biometricpunchingreportRepo.save(biometricpunchingreport);
	}

	@Override
	public List<BiometricPunchingReport> getAllBiometricPunchingReport() {
		return biometricpunchingreportRepo.findAll();
	}
}
