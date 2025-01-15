package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.JoiningReport;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JoiningRepository extends JpaRepository<JoiningReport, Long> {
	List<JoiningReport> findByJoiningEmployee_EmpId(Long employeeId);


}
