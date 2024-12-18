package com.gentech.erp.hr.mapper;


import com.gentech.erp.hr.dto.BiometricAttendanceDto;
import com.gentech.erp.hr.entity.BiometricAttendance;

public class BiometricAttendanceMapper {
	public static BiometricAttendanceDto mapBiometricAttendanceToBiometricAttendanceDto(BiometricAttendance biometricAttendance){
		BiometricAttendanceDto biometricAttendanceDto=new BiometricAttendanceDto(
				biometricAttendance.getBiometricId(),
				biometricAttendance.getAttendanceDate(),
				biometricAttendance.getTimeIn(),
				biometricAttendance.getTimeOut(),
				biometricAttendance.getTotalHoursWorked(),
				biometricAttendance.getDutyType(),
				biometricAttendance.getEmployee()
				
        );
        return biometricAttendanceDto;
    }
	public static BiometricAttendance mapBiometricAttendanceDtoToBiometricAttendance(BiometricAttendanceDto biometricAttendanceDto){
		BiometricAttendance biometricAttendance=new BiometricAttendance(
        		biometricAttendanceDto.getBiometricId(),
				biometricAttendanceDto.getAttendanceDate(),
				biometricAttendanceDto.getTimeIn(),
				biometricAttendanceDto.getTimeOut(),
				biometricAttendanceDto.getTotalHoursWorked(),
				biometricAttendanceDto.getDutyType(),
				biometricAttendanceDto.getEmployee()
        );
        return biometricAttendance;
    }
}
