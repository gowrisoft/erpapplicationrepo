package com.gentech.hr.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.hr.entity.Employee;
import com.gentech.hr.repository.EmployeeRepository;
import com.gentech.hr.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee createEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
