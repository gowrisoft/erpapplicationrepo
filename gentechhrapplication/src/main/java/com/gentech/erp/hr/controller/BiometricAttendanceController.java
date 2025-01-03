package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;
import com.gentech.erp.hr.service.BiometricAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BiometricAttendanceController {

    @Autowired
    private BiometricAttendanceService biometricattendanceService;

    @PostMapping("/bioattendance")
    public ResponseEntity<BiometricAttendanceDto> createBiometricAttendance(@RequestBody BiometricAttendanceDto biometricattendanceDto) {
        return new ResponseEntity<BiometricAttendanceDto>(biometricattendanceService.createBiometricAttendance(biometricattendanceDto), HttpStatus.CREATED);
    }

    @GetMapping("/bioattendances")
    public ResponseEntity<List<BiometricAttendanceDto>> getAllBiometricAttendance() {
        return new ResponseEntity<List<BiometricAttendanceDto>>(biometricattendanceService.getAllBiometricAttendance(), HttpStatus.OK);
    }

}