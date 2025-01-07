package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByEmployee_EmpId(Long employeeEmpId);

}


