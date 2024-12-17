package com.gentech.hr.service;

import java.util.List;
import com.gentech.hr.entity.PrintJoiningReports;

public interface PrintJoiningReportsService {
	
	PrintJoiningReports createPrintReports( PrintJoiningReports print);
	
	List<PrintJoiningReports> getAllPrintReportss();

}
