package com.gentech.erp.hr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.service.BiometricPunchingReportService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")

public class BiometricPunchingReportController {

    @Autowired
    private BiometricPunchingReportService biometricpunchingreportService;

    @PostMapping("/biometricreport")
    public ResponseEntity<BiometricPunchingReportDto> createBiometricPunchingReport(@RequestBody BiometricPunchingReportDto biometricpunchingreportDto)
    {
        return new ResponseEntity<BiometricPunchingReportDto>(biometricpunchingreportService.createBiometricPunchingReport(biometricpunchingreportDto), HttpStatus.CREATED);
    }

    @GetMapping("/biometricreports")
    public ResponseEntity<List<BiometricPunchingReportDto>> getAllBiometricPunchingReport()
    {
        return new ResponseEntity<List<BiometricPunchingReportDto>>(biometricpunchingreportService.getAllBiometricPunchingReport(), HttpStatus.OK);
    }

    @DeleteMapping("/delbiometricreport/{id}")
    public ResponseEntity<String> deleteBiometricPunchingReportById(@PathVariable Long id) {
        biometricpunchingreportService.deleteBiometricPunchingReportById(id);
        return new ResponseEntity<>("BiometricPunchingReport record deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getbiometricreportById/{id}")
    public ResponseEntity<BiometricPunchingReportDto> getBiometricPunchingReportById(@PathVariable Long id) {
        BiometricPunchingReportDto biometricPunchingReport = biometricpunchingreportService.getBiometricPunchingReportById(id);
        return new ResponseEntity<>(biometricPunchingReport, HttpStatus.OK);
    }

    // Modify Joining Report
    @PutMapping("/modbiometricreport/{id}")
    public ResponseEntity<BiometricPunchingReportDto> updateBiometricPunchingReport(@PathVariable Long id,
                                                                                    @RequestBody BiometricPunchingReportDto biometricpunchingreportDto) {
        BiometricPunchingReportDto updatedBiometricPunchingReport = biometricpunchingreportService.updateBiometricPunchingReport(id, biometricpunchingreportDto);
        return new ResponseEntity<>(updatedBiometricPunchingReport, HttpStatus.OK);
    }

}

