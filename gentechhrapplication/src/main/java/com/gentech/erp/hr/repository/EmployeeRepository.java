package com.gentech.erp.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gentech.erp.hr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
