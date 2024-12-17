package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(long id);
    String deleteEmployeeById(long id);
}