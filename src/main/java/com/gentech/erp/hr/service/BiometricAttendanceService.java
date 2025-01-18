package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;

import java.util.List;

public interface BiometricAttendanceService {


    BiometricAttendanceDto createBiometricAttendance(BiometricAttendanceDto biometricattendanceDto);

    List<BiometricAttendanceDto> getAllBiometricAttendance();

    void deleteBiometricAttendanceById(Long id);

    BiometricAttendanceDto getBiometricAttendanceById(Long id);

    BiometricAttendanceDto updateBiometricAttendance(Long id,BiometricAttendanceDto biometricAttendanceDto);

	List<BiometricAttendanceDto> getBiometricAttendanceByEmployeeId(Long employeeId);

}