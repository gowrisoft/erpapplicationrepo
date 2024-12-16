package com.gentech.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.hr.entity.BiometricAttendance;
import com.gentech.hr.service.BiometricAttendanceService;

@RestController
@RequestMapping("/api/v1")
public class BiometricAttendanceController {

	@Autowired
	private BiometricAttendanceService biometricattendanceService;
	
	@PostMapping("/bioattendance")
	public ResponseEntity<BiometricAttendance> createBiometricAttendance(@RequestBody BiometricAttendance biometricattendance)
	{
		return new ResponseEntity<BiometricAttendance>(biometricattendanceService.createBiometricAttendance(biometricattendance), HttpStatus.CREATED);
	}
	
	@GetMapping("/bioattendances")
	public ResponseEntity<List<BiometricAttendance>> getAllBiometricAttendance()
	{
		return new ResponseEntity<List<BiometricAttendance>>(biometricattendanceService.getAllBiometricAttendance(), HttpStatus.OK);
	}
	
}