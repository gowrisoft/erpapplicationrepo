package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.EmployeeMapper;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employeeEntity= EmployeeMapper.mapEmpDtoToEmp(employeeDto);
        employeeRepository.save(employeeEntity);
        EmployeeDto employeeDto1=EmployeeMapper.mapEmpToEmpDto(employeeEntity);
        return employeeDto1;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeEntityList=employeeRepository.findAll();
        List<EmployeeDto> employeeDto=employeeEntityList.stream().map((employee)->EmployeeMapper.mapEmpToEmpDto(employee)).toList();
        return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));

        return EmployeeMapper.mapEmpToEmpDto(employee);
    }

    @Override
    @Transactional
    public String deleteEmployeeById(long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));

        if(employee==null){
            return "Employee with employee id : "+id+" is not found in the database";
        }
        employeeRepository.deleteById(id);
        return "Employee with employee id : "+id+" deleted successfully in the database";
    }
}
