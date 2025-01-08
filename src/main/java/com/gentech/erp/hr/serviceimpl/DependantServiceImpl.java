package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.DependantDto;
import com.gentech.erp.hr.entity.Dependant;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.DependantsRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.DependantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependantServiceImpl implements DependantService {

    @Autowired
    private DependantsRepository dependantsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DependantDto saveDependant(DependantDto dependantsDto) {
        Employee employee = employeeRepository.findById(dependantsDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Dependant dependant = modelMapper.map(dependantsDto, Dependant.class);
        dependant.setEmployee(employee);
        return modelMapper.map(dependantsRepository.save(dependant), DependantDto.class);
    }

    @Override
    public List<DependantDto> getAllDependant() {
        return dependantsRepository.findAll().stream()
                .map(dependant -> modelMapper.map(dependant, DependantDto.class)).collect(Collectors.toList());
    }

    @Override
    public DependantDto getDependantById(Long dependantId) throws Exception {
        return modelMapper.map(dependantsRepository.findById(dependantId)
                .orElseThrow(() -> new Exception("Dependent is not present with id " + dependantId)), DependantDto.class);
    }

    @Override
    public DependantDto updateItem(DependantDto dependantsDto, Long id) throws Exception {
        Dependant dependant = dependantsRepository.findById(id)
                .orElseThrow(() -> new Exception("Dependent is not present with id " + id));
        dependant.setDependantName(dependantsDto.getDependantName());
        dependant.setDependantAge(dependantsDto.getDependantAge());
        dependant.setRelationship(dependantsDto.getRelationship());

        return modelMapper.map(dependantsRepository.save(dependant), DependantDto.class);
    }

    @Override
    public void deleteItemById(Long id) {
        if (!dependantsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Dependent is not present with id " + id);
        }
        dependantsRepository.deleteById(id);
    }

    @Override
    public List<DependantDto> getDependantByEmployeeId(Long empId) {
        employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return dependantsRepository.findAllByEmployee_EmpId(empId).stream()
                .map(dependant -> modelMapper.map(dependant, DependantDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DependantDto> getDependantByDependantId(Long dependantId) {
        Dependant dependant = dependantsRepository.findByDependantId(dependantId);
        if (dependant == null) {
            throw new RuntimeException("Dependant not found for ID: " + dependantId);
        }
        List<Dependant> dependants = dependantsRepository.findAllByEmployee_EmpId(dependant.getEmployee().getEmpId());
        return dependants.stream().map(dep -> modelMapper.map(dep, DependantDto.class)).toList();
    }
}
