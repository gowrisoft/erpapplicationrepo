package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.JoiningReportDto;
import com.gentech.erp.hr.service.JoiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class JoiningController {

    @Autowired
    private JoiningService joiningService;

    // Create Joining Report
    @PostMapping("/report")
    public ResponseEntity<JoiningReportDto> createJoiningReport(@RequestBody JoiningReportDto joiningDto) {
        return new ResponseEntity<>(joiningService.createJoiningReport(joiningDto), HttpStatus.CREATED);
    }

    // Get All Joining Reports
    @GetMapping("/reports")
    public ResponseEntity<List<JoiningReportDto>> getAllJoiningReports() {
        return new ResponseEntity<>(joiningService.getAllJoiningReports(), HttpStatus.OK);
    }

    // Get Joining Report by ID
    @GetMapping("/getJoiningReportById/{id}")
    public ResponseEntity<JoiningReportDto> getJoiningReportById(@PathVariable Long id) {
        JoiningReportDto report = joiningService.getJoiningReportById(id);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    // Modify Joining Report
    @PutMapping("/modJoiningReport/{id}")
    public ResponseEntity<JoiningReportDto> updateJoiningReport(@PathVariable Long id, @RequestBody JoiningReportDto joiningDto) {
        JoiningReportDto updatedReport = joiningService.updateJoiningReport(id, joiningDto);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    // Delete Joining Report by ID
    @DeleteMapping("/delJoiningReport/{id}")
    public ResponseEntity<String> deleteJoiningReportById(@PathVariable Long id) {
        joiningService.deleteJoiningReportById(id);
        return new ResponseEntity<>("The Joining Report with ID " + id + " has been successfully marked as deleted.", HttpStatus.OK);
    }
}
