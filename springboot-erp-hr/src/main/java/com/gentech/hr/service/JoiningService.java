package com.gentech.hr.service;

import java.util.List;


import com.gentech.hr.entity.JoiningReport;

public interface JoiningService {
	
	JoiningReport createJoiningReport( JoiningReport joining);
	
	List<JoiningReport> getAllJoiningReports();

}
