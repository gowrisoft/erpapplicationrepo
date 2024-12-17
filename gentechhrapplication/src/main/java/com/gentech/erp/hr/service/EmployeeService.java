package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.entity.Employee;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, Employee updatedEmployee);

    String deleteEmployeeById(Long id);
}