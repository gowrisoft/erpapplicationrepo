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

import com.gentech.hr.entity.BiometricPunchingReport;
import com.gentech.hr.service.BiometricPunchingReportService;

@RestController
@RequestMapping("/api/v1")
public class BiometricPunchingReportController {

	@Autowired
	private BiometricPunchingReportService biometricpunchingreportService;
	
	@PostMapping("/biometricreport")
	public ResponseEntity<BiometricPunchingReport> createBiometricPunchingReport(@RequestBody BiometricPunchingReport biometricpunchingreport)
	{
		return new ResponseEntity<BiometricPunchingReport>(biometricpunchingreportService.createBiometricPunchingReport(biometricpunchingreport), HttpStatus.CREATED);
	}
	
	@GetMapping("/biometricreports")
	public ResponseEntity<List<BiometricPunchingReport>> getAllBiometricPunchingReport()
	{
		return new ResponseEntity<List<BiometricPunchingReport>>(biometricpunchingreportService.getAllBiometricPunchingReport(), HttpStatus.OK);
	}
	
}
