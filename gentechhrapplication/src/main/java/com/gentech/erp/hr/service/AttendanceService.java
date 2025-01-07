package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.AttendanceDto;

import java.util.List;

public interface AttendanceService {

    AttendanceDto createAttendance(AttendanceDto attendanceDto);

    List<AttendanceDto> getAllAttendance();

}
