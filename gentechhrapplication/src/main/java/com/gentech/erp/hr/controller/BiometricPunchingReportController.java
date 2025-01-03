package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.service.BiometricPunchingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BiometricPunchingReportController {

    @Autowired
    private BiometricPunchingReportService biometricpunchingreportService;

    @PostMapping("/biometricreport")
    public ResponseEntity<BiometricPunchingReportDto> createBiometricPunchingReport(@RequestBody BiometricPunchingReportDto biometricpunchingreportDto) {
        return new ResponseEntity<BiometricPunchingReportDto>(biometricpunchingreportService.createBiometricPunchingReport(biometricpunchingreportDto), HttpStatus.CREATED);
    }

    @GetMapping("/biometricreports")
    public ResponseEntity<List<BiometricPunchingReportDto>> getAllBiometricPunchingReport() {
        return new ResponseEntity<List<BiometricPunchingReportDto>>(biometricpunchingreportService.getAllBiometricPunchingReport(), HttpStatus.OK);
    }

}
