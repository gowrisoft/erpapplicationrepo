package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.LeaveApplicationDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.ModifyLeave;
import com.gentech.erp.hr.entity.SanctionLeave;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.LeaveApplicationMapper;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.LeaveApplicationRepository;
import com.gentech.erp.hr.repository.ModifyLeaveRepository;
import com.gentech.erp.hr.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    @Autowired
    private LeaveApplicationRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModifyLeaveRepository modifyRepository;

    @Override
    public LeaveApplicationDto addLeave(LeaveApplicationDto leaveDto) {
        Employee employeeEntity = employeeRepository.findById(leaveDto.getEmpId()).
                orElseThrow(() -> new RuntimeException("Employee not found with ID: " + leaveDto.getEmpId()));
        ModifyLeave modifyLeave = null;
        if (leaveDto.getLeaveRequestId() != 0 && leaveDto.getLeaveRequestId() > 0) {
            modifyLeave = modifyRepository.findById(leaveDto.getLeaveRequestId())
                    .orElseThrow(() -> new RuntimeException("The LeaveApplication with id " + leaveDto.getLeaveRequestId() + " is not found"));
        }
        SanctionLeave sanctionLeave = null;
        LeaveApplication leaveApplication = LeaveApplicationMapper.mapLeaveDtoToLeave(leaveDto, employeeEntity, modifyLeave, sanctionLeave);
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

    @Override
    public List<Object[]> getLeaveDetails() {
        return leaveRepository.getLeaveDetails();
    }
}