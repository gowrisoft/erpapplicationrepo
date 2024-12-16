package com.gentech.hr.service;

import java.util.List;

import com.gentech.hr.entity.RegisterRelievingReports;


public interface RegisterRelievingService {

    RegisterRelievingReports createRegisterReport( RegisterRelievingReports register);
	
	List<RegisterRelievingReports> getAllRegisterReports();
	
}
