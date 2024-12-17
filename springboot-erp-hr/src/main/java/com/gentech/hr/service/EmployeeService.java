package com.gentech.hr.service;

import java.util.List;
import com.gentech.hr.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee emp);
	
	List<Employee> getAllEmployees();

}
