package com.gentech.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.hr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
