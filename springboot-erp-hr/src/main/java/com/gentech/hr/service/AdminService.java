package com.gentech.hr.service;

import java.util.List;
import com.gentech.hr.entity.Admin;


public interface AdminService {
	
	Admin createAdmin(Admin admin);
	
	List<Admin> getAllAdmins();

}
