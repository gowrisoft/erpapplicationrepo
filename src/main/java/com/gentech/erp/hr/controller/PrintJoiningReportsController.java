package com.gentech.erp.hr.controller;

import java.util.List;

import com.gentech.erp.hr.dto.PrintJoiningReportsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.erp.hr.service.PrintJoiningReportsService;

@RestController
@RequestMapping("/api/v1")
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
	
}
