package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.PrintJoiningReports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintJoiningReportsRepository extends JpaRepository<PrintJoiningReports, Long> {

	List<PrintJoiningReports> findByPrintempId_EmpId(Long employeeId);
}
