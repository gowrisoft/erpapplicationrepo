package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.BiometricAttendance;

public interface BiometricAttendanceService {


	BiometricAttendance createBiometricAttendance(BiometricAttendance biometricattendance);
	
	List<BiometricAttendance> getAllBiometricAttendance();

}
