package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.Attendance;
import com.gentech.hr.repository.AttendanceRepository;
import com.gentech.hr.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private AttendanceRepository attendanceRepo;
	
	@Override
	public Attendance createAttendance(Attendance attendance) {
		return attendanceRepo.save(attendance);
	}

	@Override
	public List<Attendance> getAllAttendance() {
		return attendanceRepo.findAll();
	}

}
	