package com.gentech.hr.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.hr.entity.PrintJoiningReports;
import com.gentech.hr.service.PrintJoiningReportsService;

@RestController
@RequestMapping("/api/v1")
public class PrintJoiningReportsController {

	@Autowired
	private PrintJoiningReportsService printService;
	
	@PostMapping("/print")
	public ResponseEntity<PrintJoiningReports> createPrintReports(@RequestBody PrintJoiningReports print)
	{
		return new ResponseEntity<PrintJoiningReports>(printService.createPrintReports(print), HttpStatus.CREATED);
	}
	
	@GetMapping("/prints")
	public ResponseEntity<List<PrintJoiningReports>> getAllPrintReportss()
	{
		return new ResponseEntity<List<PrintJoiningReports>>(printService.getAllPrintReportss(), HttpStatus.OK);
	}
	
}
