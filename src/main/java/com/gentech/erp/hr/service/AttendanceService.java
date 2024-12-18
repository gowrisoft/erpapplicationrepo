package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.AttendanceDto;

public interface AttendanceService {

	AttendanceDto createAttendance(AttendanceDto attendanceDto);
	
	List<AttendanceDto> getAllAttendance();

}
