package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import com.gentech.erp.hr.dto.PrintJoiningReportsDto;
import com.gentech.erp.hr.mapper.PrintJoiningReportsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.erp.hr.entity.PrintJoiningReports;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.PrintJoiningReportsRepository;
import com.gentech.erp.hr.service.PrintJoiningReportsService;
@Service
public class PrintJoiningReportsServiceImpl implements PrintJoiningReportsService{

	@Autowired
	private PrintJoiningReportsRepository printRepo;

	@Override
	public PrintJoiningReportsDto createPrintReports(PrintJoiningReportsDto printDto) {
		PrintJoiningReports printJoiningReports= PrintJoiningReportsMapper.mapPrintJoinDtoToPrintJoin(printDto);
		printRepo.save(printJoiningReports);
		return PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(printJoiningReports);
	}

	@Override
	public List<PrintJoiningReportsDto> getAllPrintReportss() {
		return printRepo.findAll()
				.stream().map((printJoining)->PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(printJoining))
				.toList();
	}
	

@Override
	public PrintJoiningReportsDto getPrintJoiningReportById(Long id) {
		PrintJoiningReports printJoiningReports = printRepo.findById((long) id)
				 .orElseThrow(() -> new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
		    return PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(printJoiningReports);
	}

@Override
public PrintJoiningReportsDto updatePrintJoiningReport(Long id, PrintJoiningReportsDto printDto) {
    // Fetch the existing report from the database
    PrintJoiningReports existingReport = printRepo.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Print Joining Report", "Print ID", id));

    // Update the fields of the existing entity with values from the DTO
    existingReport.setPrintId(id); // Ensure the ID is preserved
    existingReport.setStatus(printDto.getStatus());
    existingReport.setPrintDate(printDto.getPrintDate());
    existingReport.setPrintJoiningId(printDto.getPrintJoiningId());
    existingReport.setPrintadminId(printDto.getPrintadminId());

    // Save the updated entity
    PrintJoiningReports updatedReport = printRepo.save(existingReport);

    // Map the updated entity back to a DTO and return it
    return PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(updatedReport);
}

@Override
	public void deletePrintJoiningReportById(Long id) {
		printRepo.findById(id).orElseThrow(() ->
		 new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
		printRepo.deleteById(id);
		
	}

@Override
public List<PrintJoiningReportsDto> getPrintJoiningReportByEmpId(Long employeeId) {
	// TODO Auto-generated method stub
	return printRepo.findByPrintempId_EmpId(employeeId)
			.stream().map(report -> PrintJoiningReportsMapper.mapPrintJoinToPrintJoinDto(report)).toList();
}
	
}
