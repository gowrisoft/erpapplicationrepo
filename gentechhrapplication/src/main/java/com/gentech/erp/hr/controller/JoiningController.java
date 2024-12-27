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
public class JoiningController {

    @Autowired
    private JoiningService joiningService;

    @PostMapping("/report")
    public ResponseEntity<JoiningReportDto> createJoiningReport(@RequestBody JoiningReportDto joiningDto) {
        return new ResponseEntity<JoiningReportDto>(joiningService.createJoiningReport(joiningDto), HttpStatus.CREATED);
    }

    @GetMapping("/reports")
    public ResponseEntity<List<JoiningReportDto>> getAllJoiningReports() {
        return new ResponseEntity<List<JoiningReportDto>>(joiningService.getAllJoiningReports(), HttpStatus.OK);
    }


}
