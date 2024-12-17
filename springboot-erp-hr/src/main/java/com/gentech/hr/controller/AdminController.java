package com.gentech.hr.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gentech.hr.entity.Admin;
import com.gentech.hr.service.AdminService;


@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.CREATED);
	}
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}
	
}
