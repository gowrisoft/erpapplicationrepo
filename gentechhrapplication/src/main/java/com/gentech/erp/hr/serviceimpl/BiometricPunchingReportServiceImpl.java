package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.entity.BiometricPunchingReport;
import com.gentech.erp.hr.mapper.BiometricPunchingReportMapper;
import com.gentech.erp.hr.repository.BiometricPunchingReportRepository;
import com.gentech.erp.hr.service.BiometricPunchingReportService;

@Service
public class BiometricPunchingReportServiceImpl implements BiometricPunchingReportService{

	@Autowired
	private BiometricPunchingReportRepository biometricpunchingreportRepo;

	@Override
	public BiometricPunchingReportDto createBiometricPunchingReport(
			BiometricPunchingReportDto biometricPunchingReportDto) {
		BiometricPunchingReport biometricPunchingReport = BiometricPunchingReportMapper.mapBiometricPunchingReportDtoToBiometricPunchingReport(biometricPunchingReportDto);
		biometricpunchingreportRepo.save(biometricPunchingReport);
		return BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(biometricPunchingReport);
	}
	

	@Override
	public List<BiometricPunchingReportDto> getAllBiometricPunchingReport() {
		return biometricpunchingreportRepo.findAll().
				stream().map((biometricPunchingReport)->BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(biometricPunchingReport))
				.toList();
	}
	
	
}
