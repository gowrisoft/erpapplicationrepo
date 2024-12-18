package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.dto.AttendanceDto;
import com.gentech.erp.hr.entity.Attendance;
import com.gentech.erp.hr.mapper.AttendanceMapper;
import com.gentech.erp.hr.repository.AttendanceRepository;
import com.gentech.erp.hr.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private AttendanceRepository attendanceRepo;

	@Override
	public AttendanceDto createAttendance(AttendanceDto attendanceDto) {
		Attendance attendance = AttendanceMapper.mapAttendanceDtoToAttendance(attendanceDto);
		attendanceRepo.save(attendance);
		return AttendanceMapper.mapAttendanceToAttendanceDto(attendance);
	}

	@Override
	public List<AttendanceDto> getAllAttendance() {
		return attendanceRepo.findAll().
				stream().map((attendance)->AttendanceMapper.mapAttendanceToAttendanceDto(attendance))
				.toList();
	}
}
	