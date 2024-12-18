package com.gentech.erp.hr.controller;

import java.util.List;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.erp.hr.service.RegisterRelievingService;


@RestController
@RequestMapping("/api/v1")
public class RegisterRelievingController {

	@Autowired
	private RegisterRelievingService registerService;
	
	@PostMapping("/rregister")
	public ResponseEntity<RegisterRelievingReportsDto> createRegisterReport(@RequestBody RegisterRelievingReportsDto registerDto)
	{
		return new ResponseEntity<RegisterRelievingReportsDto>(registerService.createRegisterReport(registerDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/rregisters")
	public ResponseEntity<List<RegisterRelievingReportsDto>> getAllRegisterReports()
	{
		return new ResponseEntity<List<RegisterRelievingReportsDto>>(registerService.getAllRegisterReports(), HttpStatus.OK);
	}
	
}
