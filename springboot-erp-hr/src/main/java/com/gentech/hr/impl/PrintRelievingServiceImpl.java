package com.gentech.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.PrintRelievingReports;

import com.gentech.hr.repository.PrintRelievingRepository;
import com.gentech.hr.service.PrintRelievingService;

@Service
public class PrintRelievingServiceImpl implements PrintRelievingService{
	
	@Autowired
	private PrintRelievingRepository printRepo;
	
	@Override
	public PrintRelievingReports createPrintReports(PrintRelievingReports print) {
		return printRepo.save(print);
	}

	@Override
	public List<PrintRelievingReports> getAllPrintReports() {
		return printRepo.findAll();
	}

}
