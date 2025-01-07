package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;

import java.util.List;

public interface BiometricAttendanceService {


    BiometricAttendanceDto createBiometricAttendance(BiometricAttendanceDto biometricattendanceDto);

    List<BiometricAttendanceDto> getAllBiometricAttendance();

}
