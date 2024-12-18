package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;

public interface BiometricAttendanceService {


	BiometricAttendanceDto createBiometricAttendance(BiometricAttendanceDto biometricattendanceDto);
	
	List<BiometricAttendanceDto> getAllBiometricAttendance();

}
