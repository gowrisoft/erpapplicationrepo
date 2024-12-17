package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.BiometricPunchingReport;

public interface BiometricPunchingReportService {

	BiometricPunchingReport createBiometricPunchingReport(BiometricPunchingReport biometricpunchingreport);
	
	List<BiometricPunchingReport> getAllBiometricPunchingReport();

}
