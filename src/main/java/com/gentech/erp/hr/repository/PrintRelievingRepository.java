package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.PrintRelievingReports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintRelievingRepository extends JpaRepository<PrintRelievingReports, Long> {
	List<PrintRelievingReports> findByPrintempId_EmpId(Long employeeId);
}
