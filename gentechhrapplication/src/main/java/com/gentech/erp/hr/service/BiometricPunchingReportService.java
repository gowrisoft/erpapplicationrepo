package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.entity.BiometricPunchingReport;

public interface BiometricPunchingReportService {

	BiometricPunchingReportDto createBiometricPunchingReport(BiometricPunchingReportDto biometricpunchingreportDto);
	
	List<BiometricPunchingReportDto> getAllBiometricPunchingReport();

}
