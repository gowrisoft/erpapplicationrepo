package com.gentech.erp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.erp.hr.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
}
