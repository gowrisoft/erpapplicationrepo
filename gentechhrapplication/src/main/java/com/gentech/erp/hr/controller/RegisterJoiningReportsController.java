package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.RegisterJoiningReportsDto;
import com.gentech.erp.hr.service.RegisterJoiningReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegisterJoiningReportsController {

    @Autowired
    private RegisterJoiningReportsService registerService;

    @PostMapping("/register")
    public ResponseEntity<RegisterJoiningReportsDto> createRegisterReport(@RequestBody RegisterJoiningReportsDto registerDto) {
        return new ResponseEntity<RegisterJoiningReportsDto>(registerService.createRegisterReport(registerDto), HttpStatus.CREATED);
    }

    @GetMapping("/registers")
    public ResponseEntity<List<RegisterJoiningReportsDto>> getAllRegisterReports() {
        return new ResponseEntity<List<RegisterJoiningReportsDto>>(registerService.getAllRegisterReports(), HttpStatus.OK);
    }

}
