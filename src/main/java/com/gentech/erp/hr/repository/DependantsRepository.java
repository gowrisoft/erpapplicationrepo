package com.gentech.erp.hr.repository;

import com.gentech.erp.hr.entity.Dependant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependantsRepository extends JpaRepository<Dependant, Long> {

    Dependant findByDependantId(Long dependantId);

    List<Dependant> findAllByEmployee_EmpId(Long employeeEmpId);
}
