package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.ModifyLeaveDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.ModifyLeave;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.ModifyLeaveMapper;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.LeaveApplicationRepository;
import com.gentech.erp.hr.repository.ModifyLeaveRepository;
import com.gentech.erp.hr.service.ModifyLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ModifyLeaveServiceImpl implements ModifyLeaveService {
    @Autowired
    private ModifyLeaveRepository modifyRepository;
    @Autowired
    private LeaveApplicationRepository leaveRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ModifyLeaveDto addModifyLeave(ModifyLeaveDto modifyDto) {
        Employee employeeEntity = employeeRepository.findById(modifyDto.getEmpId()).
                orElseThrow(() -> new RuntimeException("Employee with Employee Id : " + modifyDto.getEmpId() + " is not found"));

        LeaveApplication leaveApplication = leaveRepository.findById(modifyDto.getLeaveRequestId()).
                orElseThrow(() -> new RuntimeException("The LeaveApplication with id " + modifyDto.getLeaveRequestId() + " is not found"));

        ModifyLeave modifyLeave = ModifyLeaveMapper.mapModifyDtoToModify(modifyDto, employeeEntity, leaveApplication);
        modifyRepository.save(modifyLeave);
        ModifyLeaveDto modifyDto1 = ModifyLeaveMapper.mapModifyToModifyDto(modifyLeave);
        return modifyDto1;
    }

    @Override
    public List<ModifyLeaveDto> getAllModifiedLeaves() {
        return modifyRepository.findAll()
                .stream()
                .map((modifyleave) -> ModifyLeaveMapper.mapModifyToModifyDto(modifyleave))
                .toList();
    }

    @Override
    public ModifyLeaveDto getModifyLeaveById(int id) {
        ModifyLeave modifyLeave = modifyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modify Leave", "Modify leave id", id));

        return ModifyLeaveMapper.mapModifyToModifyDto(modifyLeave);
    }

    @Override
    @Transactional
    public String deleteModifyLeaveById(int id) {
        Optional<ModifyLeave> modifyLeaveOptional = modifyRepository.findById(id);
        if (modifyLeaveOptional.isEmpty()) {
            return "Modify Leave with modify leave id: " + id + " is not found in the database";
        }
        ModifyLeave modifyLeave = modifyLeaveOptional.get();
        Employee employee = modifyLeave.getEmployee();
        if (employee != null) {
            employee.getModifyLeaves().remove(modifyLeave);
        }
        LeaveApplication leaveApplication = modifyLeave.getLeaveApplication();
        if (leaveApplication != null) {
            leaveApplication.setModifyLeave(null); // Nullify the reference
        }
        modifyRepository.delete(modifyLeave);
        return "Modify Leave with modify leave id: " + id + " successfully deleted";
    }


}