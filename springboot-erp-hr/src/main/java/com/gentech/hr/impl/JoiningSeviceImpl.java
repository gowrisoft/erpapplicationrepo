package com.gentech.hr.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.hr.entity.JoiningReport;
import com.gentech.hr.repository.JoiningRepository;
import com.gentech.hr.service.JoiningService;
@Service
public class JoiningSeviceImpl implements JoiningService{

	@Autowired
	private JoiningRepository joiningRepo;
	
	@Override
	public JoiningReport createJoiningReport(JoiningReport joining) {
		return joiningRepo.save(joining);
	}

	@Override
	public List<JoiningReport> getAllJoiningReports() {
		return joiningRepo.findAll();
	}

}
