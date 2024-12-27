package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import com.gentech.erp.hr.service.PrintRelievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrintRelievingController {

    @Autowired
    private PrintRelievingService printService;

    @PostMapping("/rprint")
    public ResponseEntity<PrintRelievingReportsDto> createPrintReports(@RequestBody PrintRelievingReportsDto printDto) {
        return new ResponseEntity<PrintRelievingReportsDto>(printService.createPrintReports(printDto), HttpStatus.CREATED);
    }

    @GetMapping("/rprints")
    public ResponseEntity<List<PrintRelievingReportsDto>> getAllPrintReports() {
        return new ResponseEntity<List<PrintRelievingReportsDto>>(printService.getAllPrintReports(), HttpStatus.OK);
    }


}
