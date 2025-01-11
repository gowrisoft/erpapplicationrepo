package com.gentech.erp.hr.controller;

import java.util.List;
import com.gentech.erp.hr.dto.PrintJoiningReportsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.gentech.erp.hr.service.PrintJoiningReportsService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PrintJoiningReportsController {

    @Autowired
    private PrintJoiningReportsService printService;

    @PostMapping("/print")
    public ResponseEntity<PrintJoiningReportsDto> createPrintReports(@RequestBody PrintJoiningReportsDto printDto)
    {
        return new ResponseEntity<PrintJoiningReportsDto>(printService.createPrintReports(printDto), HttpStatus.CREATED);
    }

    @GetMapping("/prints")
    public ResponseEntity<List<PrintJoiningReportsDto>> getAllPrintReportss()
    {
        return new ResponseEntity<List<PrintJoiningReportsDto>>(printService.getAllPrintReportss(), HttpStatus.OK);
    }


    @GetMapping("/PrintJoiningReportById/{id}")
    public ResponseEntity<PrintJoiningReportsDto> getPrintJoiningReportById(@PathVariable Long id) {
        PrintJoiningReportsDto reportPrintJoining = printService.getPrintJoiningReportById( id);
        return new ResponseEntity<>(reportPrintJoining, HttpStatusCode.valueOf(200));
    }

    @PutMapping("/PrintJoiningReport/{id}")
    public ResponseEntity<PrintJoiningReportsDto> updatePrintJoiningReport(
            @PathVariable Long id,
            @RequestBody PrintJoiningReportsDto printJoiningDto) {
        PrintJoiningReportsDto updatedReport = printService.updatePrintJoiningReport(id, printJoiningDto);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }


    @DeleteMapping("/delPrintJoiningReport/{id}")
    public ResponseEntity<String> deletePrintJoiningReportById(@PathVariable Long id) {
        printService.deletePrintJoiningReportById(id);
        return new ResponseEntity<>(
                "The Relieving Report with ID " + id + " has been successfully marked as deleted.",
                HttpStatus.OK
        );
    }

}
