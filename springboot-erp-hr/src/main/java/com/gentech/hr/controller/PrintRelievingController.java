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
import com.gentech.hr.entity.PrintRelievingReports;
import com.gentech.hr.service.PrintRelievingService;

@RestController
@RequestMapping("/api/v1")
public class PrintRelievingController {
	
	@Autowired
	private PrintRelievingService printService;
	
	@PostMapping("/rprint")
	public ResponseEntity<PrintRelievingReports> createPrintReports(@RequestBody PrintRelievingReports print)
	{
		return new ResponseEntity<PrintRelievingReports>(printService.createPrintReports(print), HttpStatus.CREATED);
	}
	
	@GetMapping("/rprints")
	public ResponseEntity<List<PrintRelievingReports>> getAllPrintReports()
	{
		return new ResponseEntity<List<PrintRelievingReports>>(printService.getAllPrintReports(), HttpStatus.OK);
	}
	
	
	

}
