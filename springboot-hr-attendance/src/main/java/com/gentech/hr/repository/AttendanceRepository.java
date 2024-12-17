package com.gentech.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.hr.entity.Attendance;


public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

}
