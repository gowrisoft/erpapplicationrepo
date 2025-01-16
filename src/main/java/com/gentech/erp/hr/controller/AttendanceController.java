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

import com.gentech.erp.hr.dto.AttendanceDto;
import com.gentech.erp.hr.service.AttendanceService;

@RestController
@RequestMapping("/v1/api")

public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@PostMapping("/attendance")
	public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto) {
		return new ResponseEntity<AttendanceDto>(attendanceService.createAttendance(attendanceDto), HttpStatus.CREATED);
	}

	@GetMapping("/admin/attendances")
	public ResponseEntity<List<AttendanceDto>> getAllAttendance() {
		return new ResponseEntity<List<AttendanceDto>>(attendanceService.getAllAttendance(), HttpStatus.OK);
	}

	@DeleteMapping("/delattendance/{id}")
	public ResponseEntity<String> deleteAttendance(@PathVariable Long id) {
		attendanceService.deleteAttendanceById(id);
		return new ResponseEntity<>("Attendance record deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getAttendanceById/{id}")
	public ResponseEntity<AttendanceDto> getJoiningReportById(@PathVariable Long id) {
		AttendanceDto attendance = attendanceService.getAttendanceById(id);
		return new ResponseEntity<>(attendance, HttpStatus.OK);
	}

	// Modify Joining Report
	@PutMapping("/modattendance/{id}")
	public ResponseEntity<AttendanceDto> updateJoiningReport(@PathVariable Long id,
			@RequestBody AttendanceDto attendanceDto) {
		AttendanceDto updatedAttendance = attendanceService.updateAttendance(id, attendanceDto);
		return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
	}
	
	@GetMapping("/attendances/employee/{employeeId}")
    public ResponseEntity<List<AttendanceDto>> getAttendanceByEmployeeId(@PathVariable Long employeeId) {
        List<AttendanceDto> attendances = attendanceService.getAttendanceByEmployeeId(employeeId);
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

	@GetMapping("/user/attendances")
	public ResponseEntity<List<AttendanceDto>> getAttendanceOfEmployee(HttpServletRequest request) {
		List<AttendanceDto> attendances = attendanceService.getAttendanceByEmployeeId((Long) request.getAttribute("employeeId"));
		return new ResponseEntity<>(attendances, HttpStatus.OK);
	}
}
