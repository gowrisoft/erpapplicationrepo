package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee);

    String deleteEmployeeById(Long id);
}