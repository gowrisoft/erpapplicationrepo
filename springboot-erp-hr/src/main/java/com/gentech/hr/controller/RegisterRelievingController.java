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

import com.gentech.hr.entity.RegisterRelievingReports;
import com.gentech.hr.service.RegisterRelievingService;


@RestController
@RequestMapping("/api/v1")
public class RegisterRelievingController {

	@Autowired
	private RegisterRelievingService registerService;
	
	@PostMapping("/rregister")
	public ResponseEntity<RegisterRelievingReports> createRegisterReport(@RequestBody RegisterRelievingReports register)
	{
		return new ResponseEntity<RegisterRelievingReports>(registerService.createRegisterReport(register), HttpStatus.CREATED);
	}
	
	@GetMapping("/rregisters")
	public ResponseEntity<List<RegisterRelievingReports>> getAllRegisterReports()
	{
		return new ResponseEntity<List<RegisterRelievingReports>>(registerService.getAllRegisterReports(), HttpStatus.OK);
	}
	
}
