package com.gentech.hr.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.hr.entity.Admin;
import com.gentech.hr.repository.AdminRepository;
import com.gentech.hr.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	
	@Override
	public Admin createAdmin(Admin admin) {
	return adminRepo.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}
	
	

}
