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
import com.gentech.hr.entity.RegisterJoiningReports;
import com.gentech.hr.service.RegisterJoiningReportsService;

@RestController
@RequestMapping("/api/v1")
public class RegisterJoiningReportsController {

	@Autowired
	private RegisterJoiningReportsService registerService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterJoiningReports> createRegisterReport(@RequestBody RegisterJoiningReports register)
	{
		return new ResponseEntity<RegisterJoiningReports>(registerService.createRegisterReport(register), HttpStatus.CREATED);
	}
	
	@GetMapping("/registers")
	public ResponseEntity<List<RegisterJoiningReports>> getAllRegisterReports()
	{
		return new ResponseEntity<List<RegisterJoiningReports>>(registerService.getAllRegisterReports(), HttpStatus.OK);
	}
	
}
