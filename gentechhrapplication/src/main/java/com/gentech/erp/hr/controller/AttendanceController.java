package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.AttendanceDto;
import com.gentech.erp.hr.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceDto> createAttendance(@RequestBody AttendanceDto attendanceDto) {
        return new ResponseEntity<AttendanceDto>(attendanceService.createAttendance(attendanceDto), HttpStatus.CREATED);
    }

    @GetMapping("/attendances")
    public ResponseEntity<List<AttendanceDto>> getAllAttendance() {
        return new ResponseEntity<List<AttendanceDto>>(attendanceService.getAllAttendance(), HttpStatus.OK);
    }

}
