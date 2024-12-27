package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;

import java.util.List;

public interface BiometricPunchingReportService {

    BiometricPunchingReportDto createBiometricPunchingReport(BiometricPunchingReportDto biometricpunchingreportDto);

    List<BiometricPunchingReportDto> getAllBiometricPunchingReport();

}
