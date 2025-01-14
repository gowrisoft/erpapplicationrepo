package com.gentech.erp.hr.controller;

import java.util.List;
import com.gentech.erp.hr.dto.RelievingReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.erp.hr.service.RelievingService;

@RestController
@RequestMapping("v1/api") 
public class RelievingController {

	@Autowired
	private RelievingService relievingService;
	
	@PostMapping("/admin/addRelievingReport")
	public ResponseEntity<RelievingReportDto> createRelievingReport(@RequestBody RelievingReportDto relievingDto)
	{
		return new ResponseEntity<RelievingReportDto>(relievingService.createRelievingReport(relievingDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/rreports")
	public ResponseEntity<List<RelievingReportDto>> getAllRelievingReports()
	{
		return new ResponseEntity<List<RelievingReportDto>>(relievingService.getAllRelievingReports(), HttpStatus.OK);
	}
	
	@GetMapping("/admin/getRelievingReportById/{id}")
	public ResponseEntity<RelievingReportDto> getRelievingReportById(@PathVariable Long id) {
	    RelievingReportDto report = relievingService.getRelievingReportById( id);
	    return new ResponseEntity<>(report, HttpStatusCode.valueOf(200));
	}
		
	@PutMapping("/admin/modRelievingReport/{id}")
	public ResponseEntity<RelievingReportDto> updateRelievingReport(
	        @PathVariable Long id,
	        @RequestBody RelievingReportDto relievingDto) {
	    RelievingReportDto updatedReport = relievingService.updateRelievingReport(id, relievingDto);
	    return new ResponseEntity<>(updatedReport, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/admin/delRelievingReport/{id}")
	public ResponseEntity<String> deleteRelievingReportById(@PathVariable Long id) {
	    relievingService.deleteRelievingReportById(id);
	    return new ResponseEntity<>(
	        "The Relieving Report with ID " + id + " has been successfully marked as deleted.",
	        HttpStatus.OK
	    );
	}
	
	

	
}
