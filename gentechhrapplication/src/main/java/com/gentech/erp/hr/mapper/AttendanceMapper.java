package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.AttendanceDto;
import com.gentech.erp.hr.entity.Attendance;

public class AttendanceMapper {
    public static AttendanceDto mapAttendanceToAttendanceDto(Attendance attendance) {
        AttendanceDto attendanceDto = new AttendanceDto(
                attendance.getAttendanceId(),
                attendance.getAttendanceDate(),
                attendance.getAttendanceStatus(),
                attendance.getAdmin(),
                attendance.getEmployee()
        );
        return attendanceDto;
    }

    public static Attendance mapAttendanceDtoToAttendance(AttendanceDto attendanceDto) {
        Attendance attendance = new Attendance(
                attendanceDto.getAttendanceId(),
                attendanceDto.getAttendanceDate(),
                attendanceDto.getAttendanceStatus(),
                attendanceDto.getAdmin(),
                attendanceDto.getEmployee()
        );
        return attendance;
    }
}
