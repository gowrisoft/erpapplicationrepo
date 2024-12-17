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

import com.gentech.hr.entity.Attendance;
import com.gentech.hr.service.AttendanceService;

@RestController
@RequestMapping("/api/v1")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping("/attendance")
	public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance)
	{
		return new ResponseEntity<Attendance>(attendanceService.createAttendance(attendance), HttpStatus.CREATED);
	}
	
	@GetMapping("/attendances")
	public ResponseEntity<List<Attendance>> getAllAttendance()
	{
		return new ResponseEntity<List<Attendance>>(attendanceService.getAllAttendance(), HttpStatus.OK);
	}
	
}
