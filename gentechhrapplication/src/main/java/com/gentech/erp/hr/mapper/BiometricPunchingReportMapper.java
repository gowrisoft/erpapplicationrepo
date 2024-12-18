package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.entity.BiometricPunchingReport;

public class BiometricPunchingReportMapper {
	public static BiometricPunchingReportDto mapBiometricPunchingReportToBiometricPunchingReportDto(BiometricPunchingReport biometricPunchingReport){
		BiometricPunchingReportDto biometricPunchingReportDto=new BiometricPunchingReportDto(
				biometricPunchingReport.getReportId(),
				biometricPunchingReport.getEmployee(),
				biometricPunchingReport.getEmpName(),
				biometricPunchingReport.getDate(),
				biometricPunchingReport.getTimeIn(),
				biometricPunchingReport.getTimeOut(),
				biometricPunchingReport.getNumOfPunches(),
				biometricPunchingReport.getDesignation(),
				biometricPunchingReport.getLocation(),
				biometricPunchingReport.getBiometricAttendance()
				);
        return biometricPunchingReportDto;
    }
	public static BiometricPunchingReport mapBiometricPunchingReportDtoToBiometricPunchingReport(BiometricPunchingReportDto biometricPunchingReportDto){
		BiometricPunchingReport biometricPunchingReport=new BiometricPunchingReport(
				biometricPunchingReportDto.getReportId(),
				biometricPunchingReportDto.getEmployee(),
				biometricPunchingReportDto.getEmpName(),
				biometricPunchingReportDto.getDate(),
				biometricPunchingReportDto.getTimeIn(),
				biometricPunchingReportDto.getTimeOut(),
				biometricPunchingReportDto.getNumOfPunches(),
				biometricPunchingReportDto.getDesignation(),
				biometricPunchingReportDto.getLocation(),
				biometricPunchingReportDto.getBiometricAttendance()
        );
        return biometricPunchingReport;
    }
}
