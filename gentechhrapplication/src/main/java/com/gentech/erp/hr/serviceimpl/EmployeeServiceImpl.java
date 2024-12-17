package com.gentech.erp.hr.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employeeEntity = modelMapper.map(employeeDto , Employee.class);
        employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> modelMapper.map(employee , EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found")), EmployeeDto.class);
    }

    @Override
    @Transactional
    public String deleteEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));

        if(employee==null){
            return "Employee with employee id : "+id+" is not found in the database";
        }
        employeeRepository.deleteById(id);
        return "Employee with employee id : "+id+" deleted successfully in the database";
    }
}
