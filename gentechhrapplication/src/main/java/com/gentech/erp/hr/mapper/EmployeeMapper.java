package com.gentech.erp.hr.mapper;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.entity.Employee;

public class EmployeeMapper {
    public static Employee mapEmpDtoToEmp(EmployeeDto employeeDto){
        Employee employeeEntity=new Employee(
                employeeDto.getEmpId(),
                employeeDto.getEmpName(),
                employeeDto.getEmpEmail(),
                employeeDto.getEmpPhone(),
                employeeDto.getEmpDesignation(),
                employeeDto.getJoiningDate(),
                null,
                null,
                null,
                null
        );
        return employeeEntity;
    }
    public static EmployeeDto mapEmpToEmpDto(Employee employeeEntity){
        EmployeeDto employeeDto=new EmployeeDto(
                employeeEntity.getEmpId(),
                employeeEntity.getEmpName(),
                employeeEntity.getEmpEmail(),
                employeeEntity.getEmpPhone(),
                employeeEntity.getEmpDesignation(),
                employeeEntity.getJoiningDate()
        );
        return employeeDto;
    }
}

