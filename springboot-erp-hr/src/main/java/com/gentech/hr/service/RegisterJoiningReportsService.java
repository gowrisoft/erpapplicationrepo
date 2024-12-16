package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.RegisterJoiningReports;

public interface RegisterJoiningReportsService {

    RegisterJoiningReports createRegisterReport( RegisterJoiningReports register);
	
	List<RegisterJoiningReports> getAllRegisterReports();
	
}
