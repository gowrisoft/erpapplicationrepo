package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;
import com.gentech.erp.hr.service.RegisterRelievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RegisterRelievingController {

    @Autowired
    private RegisterRelievingService registerService;

    @PostMapping("/rregister")
    public ResponseEntity<RegisterRelievingReportsDto> createRegisterReport(@RequestBody RegisterRelievingReportsDto registerDto) {
        return new ResponseEntity<RegisterRelievingReportsDto>(registerService.createRegisterReport(registerDto), HttpStatus.CREATED);
    }

    @GetMapping("/rregisters")
    public ResponseEntity<List<RegisterRelievingReportsDto>> getAllRegisterReports() {
        return new ResponseEntity<List<RegisterRelievingReportsDto>>(registerService.getAllRegisterReports(), HttpStatus.OK);
    }

}
