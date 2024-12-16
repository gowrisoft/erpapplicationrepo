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
import com.gentech.hr.entity.RelievingReport;
import com.gentech.hr.service.RelievingService;

@RestController
@RequestMapping("/api/v1")
public class RelievingController {

	@Autowired
	private RelievingService relievingService;
	
	@PostMapping("/report")
	public ResponseEntity<RelievingReport> createRelievingReport(@RequestBody RelievingReport relieving)
	{
		return new ResponseEntity<RelievingReport>(relievingService.createRelievingReport(relieving), HttpStatus.CREATED);
	}
	
	@GetMapping("/reports")
	public ResponseEntity<List<RelievingReport>> getAllRelievingReports()
	{
		return new ResponseEntity<List<RelievingReport>>(relievingService.getAllRelievingReports(), HttpStatus.OK);
	}
	
}
