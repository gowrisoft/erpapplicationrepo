package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.Attendance;

public interface AttendanceService {

	Attendance createAttendance(Attendance attendance);
	
	List<Attendance> getAllAttendance();

}
