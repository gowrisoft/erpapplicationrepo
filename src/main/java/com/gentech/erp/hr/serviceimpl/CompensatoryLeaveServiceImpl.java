package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.CompensatoryLeaveMapper;
import com.gentech.erp.hr.repository.CompensatoryLeaveRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.CompensatoryLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompensatoryLeaveServiceImpl implements CompensatoryLeaveService {
    @Autowired
    private CompensatoryLeaveRepository compensatoryLeaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CompensatoryLeaveDto addCompensatoryLeave(CompensatoryLeaveDto compensatoryLeaveDto) {
        Employee employee = employeeRepository.findById(compensatoryLeaveDto.getEmpId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "emp_id", compensatoryLeaveDto.getEmpId()));

        CompensatoryLeave compensatoryLeaveEntity = CompensatoryLeaveMapper.mapCompDtoToComp(compensatoryLeaveDto, employee);
        compensatoryLeaveRepository.save(compensatoryLeaveEntity);

        CompensatoryLeaveDto compensatoryLeaveDto1 = CompensatoryLeaveMapper.mapCompToCompDto(compensatoryLeaveEntity);
        return compensatoryLeaveDto1;
    }

    @Override
    public List<CompensatoryLeaveDto> getAllCompensatoryLeaves() {
        return compensatoryLeaveRepository.findAll()
                .stream()
                .map((compensatoryLeave) -> CompensatoryLeaveMapper.mapCompToCompDto(compensatoryLeave))
                .toList();
    }

    @Override
    public CompensatoryLeaveDto getAllCompensatoryLeaveById(int id) {
        CompensatoryLeave compensatoryLeaveEntity = compensatoryLeaveRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("compensatory leave", "compensatory leave id", id));

        return CompensatoryLeaveMapper.mapCompToCompDto(compensatoryLeaveEntity);
    }

    @Override
    public List<CompensatoryLeaveDto> getCompensatoryLeaveByEmployeeId(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "emp_id", id));

        List<CompensatoryLeave> compensatoryLeaves = compensatoryLeaveRepository.getCompensatoryLeavesByEmployeeId(id);
        return compensatoryLeaves.stream()
                .map((compensatoryLeave) -> CompensatoryLeaveMapper.mapCompToCompDto(compensatoryLeave))
                .toList();
    }

    @Override
    @Transactional
    public String deleteCompensatoryLeaveById(int id) {
        CompensatoryLeave compensatoryLeaveEntity = compensatoryLeaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "Compensatory Leave id", id));

        if (compensatoryLeaveEntity == null) {
            return "Compensatory Leave with compensatory leave id : " + id + " is not found in the database";
        }
        compensatoryLeaveRepository.deleteById(id);
        return "Compensatory Leave with compensatory leave id : " + id + " deleted successfully in the database";
    }

    @Override
    public CompensatoryLeaveDto updateCompensatoryLeave(int id,CompensatoryLeaveDto compensatoryLeaveDto) {
        CompensatoryLeave compensatoryLeave=compensatoryLeaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "Compensatory Leave id", id));

        compensatoryLeave.setLeaveDate(compensatoryLeaveDto.getLeaveDate());
        compensatoryLeave.setCompensatoryReason(compensatoryLeaveDto.getCompensatoryReason());
        compensatoryLeave.setStartDate(compensatoryLeaveDto.getStartDate());
        compensatoryLeave.setEndDate(compensatoryLeaveDto.getEndDate());
        compensatoryLeave.setStatus(compensatoryLeaveDto.getStatus());

        CompensatoryLeave updatedCompensatoryLeave=compensatoryLeaveRepository.save(compensatoryLeave);

        return CompensatoryLeaveMapper.mapCompToCompDto(updatedCompensatoryLeave);
    }

}
