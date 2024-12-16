package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.PrintRelievingReports;



public interface PrintRelievingService {
	

	PrintRelievingReports createPrintReports( PrintRelievingReports print);
	
	List<PrintRelievingReports> getAllPrintReports();

}
