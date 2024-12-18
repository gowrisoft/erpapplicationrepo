package com.gentech.erp.hr.controller;

import java.util.List;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.erp.hr.service.PrintRelievingService;

@RestController
@RequestMapping("/api/v1")
public class PrintRelievingController {
	
	@Autowired
	private PrintRelievingService printService;
	
	@PostMapping("/rprint")
	public ResponseEntity<PrintRelievingReportsDto> createPrintReports(@RequestBody PrintRelievingReportsDto printDto)
	{
		return new ResponseEntity<PrintRelievingReportsDto>(printService.createPrintReports(printDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/rprints")
	public ResponseEntity<List<PrintRelievingReportsDto>> getAllPrintReports()
	{
		return new ResponseEntity<List<PrintRelievingReportsDto>>(printService.getAllPrintReports(), HttpStatus.OK);
	}
	
	
	

}
