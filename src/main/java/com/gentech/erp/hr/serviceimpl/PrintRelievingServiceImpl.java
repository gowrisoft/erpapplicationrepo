package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import com.gentech.erp.hr.dto.PrintRelievingReportsDto;
import com.gentech.erp.hr.mapper.PrintRelievingReportsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.entity.PrintRelievingReports;

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

}
