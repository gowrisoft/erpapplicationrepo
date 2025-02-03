package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.EmployeeDto;
import com.gentech.erp.hr.dto.EmployeeUserDTO;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        try {
            Employee employeeEntity = modelMapper.map(employeeDto, Employee.class);
            employeeRepository.save(employeeEntity);
            return modelMapper.map(employeeEntity, EmployeeDto.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving employee: " + e.getMessage());
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found")), EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                    employee.setBaseSalary(updatedEmployee.getBaseSalary());
                    employee.setAllowances(updatedEmployee.getAllowances());
                    employee.setDateOfJoining(updatedEmployee.getDateOfJoining());
                    employee.setEmpDesignation(updatedEmployee.getEmpDesignation());

                    return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    @Transactional
    public String deleteEmployeeById(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Employee Id", id));

        employeeRepository.deleteById(id);
        return String.format("Employee with employee ID %d deleted successfully from the database", id);
    }

    @Override
    public List<EmployeeUserDTO> getAllEmployeesForUser() {
        return employeeRepository.findAll().stream().map(employee -> modelMapper.map(employee, EmployeeUserDTO.class)).toList();
    }

}
