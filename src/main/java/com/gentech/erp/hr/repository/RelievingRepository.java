package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.RelievingReport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RelievingRepository extends JpaRepository<RelievingReport, Long> {
	List<RelievingReport> findByRelievingEmployee_EmpId(Long employeeId);

}
