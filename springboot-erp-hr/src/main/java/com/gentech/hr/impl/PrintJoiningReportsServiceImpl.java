package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.hr.entity.PrintJoiningReports;
import com.gentech.hr.repository.PrintJoiningReportsRepository;
import com.gentech.hr.service.PrintJoiningReportsService;
@Service
public class PrintJoiningReportsServiceImpl implements PrintJoiningReportsService{

	@Autowired
	private PrintJoiningReportsRepository printRepo;

	@Override
	public PrintJoiningReports createPrintReports(PrintJoiningReports print) {
		return printRepo.save(print);
	}

	@Override
	public List<PrintJoiningReports> getAllPrintReportss() {
		return printRepo.findAll();
	}
	
}
