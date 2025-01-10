package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.LeaveApplicationDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.SanctionLeave;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.LeaveApplicationMapper;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.LeaveApplicationRepository;
import com.gentech.erp.hr.service.LeaveApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    @Autowired
    private LeaveApplicationRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public LeaveApplicationDto addLeave(LeaveApplicationDto leaveDto) {
        Employee employeeEntity = employeeRepository.findById(leaveDto.getEmpId()).
                orElseThrow(() -> new RuntimeException("Employee not found with ID: " + leaveDto.getEmpId()));
        SanctionLeave sanctionLeave = null;
        LeaveApplication leaveApplication = LeaveApplicationMapper.mapLeaveDtoToLeave(leaveDto, employeeEntity, sanctionLeave);
        leaveRepository.save(leaveApplication);
        LeaveApplicationDto leaveDto1 = LeaveApplicationMapper.mapLeaveToLeaveDto(leaveApplication);
        return leaveDto1;
    }

    @Override
    public List<LeaveApplicationDto> getAllLeaves() {
        List<LeaveApplication> leaveApplications = leaveRepository.findAll();
        return leaveApplications.stream().
                map((leaves) -> LeaveApplicationMapper.mapLeaveToLeaveDto(leaves))
                .toList();
    }

    @Override
    public LeaveApplicationDto getLeaveById(int id) {
        LeaveApplication leaveApplication = leaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave application", "leave id", id));

        return LeaveApplicationMapper.mapLeaveToLeaveDto(leaveApplication);
    }

    @Override
    public String deleteLeaveById(int id) {
        LeaveApplication leaveApplication = leaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave Application", "Leave id", id));

        if (leaveApplication == null) {
            return "Leave Application with Leave id : " + id + " is not found in the database";
        }
        leaveRepository.deleteById(id);
        return "Leave Application with Leave id : " + id + " is successfully deleted in the database";
    }

    @Override
    public List<Integer> getLeaveApplicationIdByEmployeeId(long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        return leaveRepository.getLeaveIdByEmployeeId(id);
    }

    @Override
    public List<LeaveApplicationDto> getLeaveApplicationByEmployeeId(long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Employee id",id));

        List<LeaveApplication> leaveApplication=leaveRepository.getLeavesByEmployeeId(id);
        return leaveApplication.stream()
                .map((leaves)->LeaveApplicationMapper.mapLeaveToLeaveDto(leaves))
                .toList();
    }

    @Transactional
    @Override
    public LeaveApplicationDto updateLeaveApplication(int id, LeaveApplicationDto leaveDto) {
        // Fetch the existing leave application from the database
        LeaveApplication leaveApplication = leaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave Application", "Leave id", id));

        // Debug: Check existing values
        System.out.println("Existing Leave Application: " + leaveApplication);

        // Validate and update fields
        if (leaveDto.getStartDate() != null) {
            // Ensure the start date is correctly set as Date
            leaveApplication.setStartDate(leaveDto.getStartDate()); // Convert String to Date
        } else {
            throw new IllegalArgumentException("Start date is required.");
        }

        if (leaveDto.getEndDate() != null) {
            leaveApplication.setEndDate(leaveDto.getEndDate()); // Convert String to Date
        } else {
            throw new IllegalArgumentException("End date is required.");
        }

        if (leaveDto.getReason() != null) {
            leaveApplication.setReason(leaveDto.getReason());
        }

        if (leaveDto.getTypeOfLeave() != null) {
            leaveApplication.setTypeOfLeave(leaveDto.getTypeOfLeave());
        }

        // Debug: Check updated values before save
        System.out.println("Updated Leave Application: " + leaveApplication);

        // Save the updated leave application back to the database
        LeaveApplication updatedLeaveApplication = leaveRepository.save(leaveApplication);

        // Debug: Confirm the entity was updated successfully
        System.out.println("Saved Updated Leave Application: " + updatedLeaveApplication);

        // Return the updated DTO
        return LeaveApplicationMapper.mapLeaveToLeaveDto(updatedLeaveApplication);
    }

}