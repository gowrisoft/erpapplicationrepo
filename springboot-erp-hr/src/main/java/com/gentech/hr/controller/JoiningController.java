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
import com.gentech.hr.entity.JoiningReport;
import com.gentech.hr.service.JoiningService;

@RestController
@RequestMapping("/api/v1")
public class JoiningController {

	@Autowired
	private JoiningService joiningService;
	
	@PostMapping("/rreport")
	public ResponseEntity<JoiningReport> createJoiningReport(@RequestBody JoiningReport joining)
	{
		return new ResponseEntity<JoiningReport>(joiningService.createJoiningReport(joining), HttpStatus.CREATED);
	}
	
	@GetMapping("/rreports")
	public ResponseEntity<List<JoiningReport>> getAllJoiningReports()
	{
		return new ResponseEntity<List<JoiningReport>>(joiningService.getAllJoiningReports(), HttpStatus.OK);
	}
	
}
