package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import com.gentech.erp.hr.mapper.PrintJoiningReportsMapper;
import com.gentech.erp.hr.mapper.PrintRelievingReportsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.erp.hr.entity.PrintRelievingReports;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.PrintRelievingRepository;
import com.gentech.erp.hr.service.PrintRelievingService;

@Service
public class PrintRelievingServiceImpl implements PrintRelievingService{
	
	@Autowired
	private PrintRelievingRepository printRepo;
	
	@Override
	public PrintRelievingReportsDto createPrintReports(PrintRelievingReportsDto printDto) {
		PrintRelievingReports printRelievingReports= PrintRelievingReportsMapper.mapPrintRelDtoToPrintRel(printDto);
		printRepo.save(printRelievingReports);
		return PrintRelievingReportsMapper.mapPrintRelToPrintRelDto(printRelievingReports);
	}

	@Override
	public List<PrintRelievingReportsDto> getAllPrintReports() {
		return printRepo.findAll()
				.stream().map((printRelieving)->PrintRelievingReportsMapper.mapPrintRelToPrintRelDto(printRelieving))
				.toList();
	}

	

@Override
	public PrintRelievingReportsDto getPrintRelievingReportById(Long id) {
		PrintRelievingReports printRelievingReports = printRepo.findById((long) id)
				 .orElseThrow(() -> new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
		    return PrintRelievingReportsMapper.mapPrintRelToPrintRelDto(printRelievingReports);
	}

@Override
public PrintRelievingReportsDto updatePrintRelievingReport(Long id, PrintRelievingReportsDto printDto) {
    // Fetch the existing report from the database
    PrintRelievingReports existingReport = printRepo.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Print Joining Report", "Print ID", id));

    // Update the fields of the existing entity with values from the DTO
    existingReport.setPrintId(id); // Ensure the ID is preserved
    existingReport.setStatus(printDto.getStatus());
    existingReport.setPrintDate(printDto.getPrintDate());
    existingReport.setPrintRelievingId(printDto.getPrintRelievingId());
    existingReport.setPrintadminId(printDto.getPrintadminId());

    // Save the updated entity
    PrintRelievingReports updatedReport = printRepo.save(existingReport);

    // Map the updated entity back to a DTO and return it
    return PrintRelievingReportsMapper.mapPrintRelToPrintRelDto(updatedReport);
}

@Override
	public void deletePrintRelievingReportById(Long id) {
		printRepo.findById(id).orElseThrow(() ->
		 new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
		printRepo.deleteById(id);
		
	}

@Override
public List<PrintRelievingReportsDto> getPrintRelievingReportByEmpId(Long employeeId) {
	return printRepo.findByPrintempId_EmpId(employeeId)
			.stream().map(report ->PrintRelievingReportsMapper.mapPrintRelToPrintRelDto(report)).toList();
}

}
