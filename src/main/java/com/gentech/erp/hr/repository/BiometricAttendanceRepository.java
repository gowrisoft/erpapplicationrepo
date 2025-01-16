package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.BiometricAttendance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BiometricAttendanceRepository extends JpaRepository<BiometricAttendance, Long> {
	
	List<BiometricAttendance> findByEmployeeEmpId(Long employeeId);


}
