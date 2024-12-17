package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.BiometricAttendance;
import com.gentech.hr.repository.BiometricAttendanceRepository;
import com.gentech.hr.service.BiometricAttendanceService;

@Service
public class BiometricAttendanceServiceImpl implements BiometricAttendanceService{

	@Autowired
	private BiometricAttendanceRepository biometricattendanceRepo;
	
	@Override
	public BiometricAttendance createBiometricAttendance(BiometricAttendance biometricattendance) {
		return biometricattendanceRepo.save(biometricattendance);
	}

	@Override
	public List<BiometricAttendance> getAllBiometricAttendance() {
		return biometricattendanceRepo.findAll();
	}
}
 