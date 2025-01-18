package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.Attendance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	List<Attendance> findByEmployeeEmpId(Long employeeId);

}
