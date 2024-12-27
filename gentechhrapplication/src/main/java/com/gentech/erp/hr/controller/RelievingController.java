package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.RelievingReportDto;
import com.gentech.erp.hr.service.RelievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RelievingController {

    @Autowired
    private RelievingService relievingService;

    @PostMapping("/rreport")
    public ResponseEntity<RelievingReportDto> createRelievingReport(@RequestBody RelievingReportDto relievingDto) {
        return new ResponseEntity<RelievingReportDto>(relievingService.createRelievingReport(relievingDto), HttpStatus.CREATED);
    }

    @GetMapping("/rreports")
    public ResponseEntity<List<RelievingReportDto>> getAllRelievingReports() {
        return new ResponseEntity<List<RelievingReportDto>>(relievingService.getAllRelievingReports(), HttpStatus.OK);
    }

}
