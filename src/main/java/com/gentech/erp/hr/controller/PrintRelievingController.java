package com.gentech.erp.hr.controller;

import java.util.List;
import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
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
import com.gentech.erp.hr.service.PrintRelievingService;

@RestController
@RequestMapping("v1/api") 
public class PrintRelievingController {
	
	@Autowired
	private PrintRelievingService printService;
	
	@PostMapping("/admin/addPrintRelievingReport")
	public ResponseEntity<PrintRelievingReportsDto> createPrintReports(@RequestBody PrintRelievingReportsDto printDto)
	{
		return new ResponseEntity<PrintRelievingReportsDto>(printService.createPrintReports(printDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/rprints")
	public ResponseEntity<List<PrintRelievingReportsDto>> getAllPrintReports()
	{
		return new ResponseEntity<List<PrintRelievingReportsDto>>(printService.getAllPrintReports(), HttpStatus.OK);
	}
	
	@GetMapping("/admin/getPrintRelievingReportByEmpId/{employeeId}")
    public ResponseEntity<List<PrintRelievingReportsDto>> getPrintRelievingReportByEmpId(@PathVariable Long employeeId) {
        List<PrintRelievingReportsDto> reports = printService.getPrintRelievingReportByEmpId(employeeId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
	
	@GetMapping("/admin/getPrintRelievingReportById/{id}")
	public ResponseEntity<PrintRelievingReportsDto> getPrintRelievingReportById(@PathVariable Long id) {
	    PrintRelievingReportsDto reportPrintRelieving = printService.getPrintRelievingReportById( id);
	    return new ResponseEntity<>(reportPrintRelieving, HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/admin/modPrintRelievingReport/{id}")
	public ResponseEntity<PrintRelievingReportsDto> updatePrintRelievingReport(
	        @PathVariable Long id,
	        @RequestBody PrintRelievingReportsDto printJoiningDto) {
	    PrintRelievingReportsDto updatedReport = printService.updatePrintRelievingReport(id, printJoiningDto);
	    return new ResponseEntity<>(updatedReport, HttpStatus.OK);
	}
	
	
	@DeleteMapping("admin/delPrintRelievingReport/{id}")
	public ResponseEntity<String> deletePrintRelievingReportById(@PathVariable Long id) {
	    printService.deletePrintRelievingReportById(id);
	    return new ResponseEntity<>(
	        "The Relieving Report with ID " + id + " has been successfully marked as deleted.",
	        HttpStatus.OK
	    );
	}
	
}
