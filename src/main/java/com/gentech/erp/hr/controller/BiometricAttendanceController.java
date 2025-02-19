package com.gentech.erp.hr.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;
import com.gentech.erp.hr.service.BiometricAttendanceService;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin("*")

public class BiometricAttendanceController {

	@Autowired
	private BiometricAttendanceService biometricattendanceService;
	
	@PostMapping("/user/bioattendance")
	public ResponseEntity<BiometricAttendanceDto> createBiometricAttendance(@RequestBody BiometricAttendanceDto biometricattendanceDto)
	{
		return new ResponseEntity<>(biometricattendanceService.createBiometricAttendance(biometricattendanceDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/bioattendances")
	public ResponseEntity<List<BiometricAttendanceDto>> getAllBiometricAttendance()
	{
		return new ResponseEntity<>(biometricattendanceService.getAllBiometricAttendance(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delbioattendance/{id}")
	public ResponseEntity<String> deleteBiometricAttendanceById(@PathVariable Long id) {
		biometricattendanceService.deleteBiometricAttendanceById(id);
		return new ResponseEntity<>("BiometricAttendance record deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getBioAttendanceById/{id}")
	public ResponseEntity<BiometricAttendanceDto> getJoiningReportById(@PathVariable Long id) {
		BiometricAttendanceDto biometricAttendance = biometricattendanceService.getBiometricAttendanceById(id);
		return new ResponseEntity<>(biometricAttendance, HttpStatus.OK);
	}

	// Modify Joining Report
	@PutMapping("/modBioAttendance/{id}")
	public ResponseEntity<BiometricAttendanceDto> updateJoiningReport(@PathVariable Long id,
			@RequestBody BiometricAttendanceDto biometricAttendanceDto) {
		BiometricAttendanceDto updatedBiometricAttendance = biometricattendanceService.updateBiometricAttendance(id, biometricAttendanceDto);
		return new ResponseEntity<>(updatedBiometricAttendance, HttpStatus.OK);
	}
	

	@GetMapping("/admin/bioattendances/employee/{employeeId}")
    public ResponseEntity<List<BiometricAttendanceDto>> getBiometricAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<BiometricAttendanceDto> bioattendances = biometricattendanceService.getBiometricAttendanceByEmployeeId(employeeId);
        return new ResponseEntity<>(bioattendances, HttpStatus.OK);
    }

	@GetMapping("/user/bioattendances")
	public ResponseEntity<List<BiometricAttendanceDto>> getBiometricAttendanceOfEmployee(HttpServletRequest request) {
		List<BiometricAttendanceDto> bioattendances = biometricattendanceService.getBiometricAttendanceByEmployeeId((Long) request.getAttribute("employeeId"));
		return new ResponseEntity<>(bioattendances, HttpStatus.OK);
	}
	
}