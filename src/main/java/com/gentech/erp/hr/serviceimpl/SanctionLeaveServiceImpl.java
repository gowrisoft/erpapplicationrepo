package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.entity.*;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.SanctionLeaveMapper;
import com.gentech.erp.hr.repository.*;
import com.gentech.erp.hr.service.SanctionLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SanctionLeaveServiceImpl implements SanctionLeaveService {
    @Autowired
    private LeaveApplicationRepository leaveRepository;
    @Autowired
    private EmployeeRepository adminRepository;
    @Autowired
    private CompensatoryLeaveRepository compensatoryLeaveRepository;
    @Autowired
    private SanctionLeaveRepository sanctionLeaveRepository;

    @Override
    public SanctionLeaveDto addSanctionLeave(SanctionLeaveDto sanctionLeaveDto) {
        LeaveApplication leaveApplication = null;
        if (sanctionLeaveDto.getLeaveRequestId() != null) {
            leaveApplication = leaveRepository.findById(sanctionLeaveDto.getLeaveRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("LeaveApplication", "Id", sanctionLeaveDto.getLeaveRequestId()));
        }

        CompensatoryLeave compensatoryLeave = null;
        if (sanctionLeaveDto.getCompensatoryLeaveId() != null) {
            compensatoryLeave = compensatoryLeaveRepository.findById(sanctionLeaveDto.getCompensatoryLeaveId())
                    .orElseThrow(() -> new ResourceNotFoundException("CompensatoryLeave", "Id", sanctionLeaveDto.getCompensatoryLeaveId()));
        }

        Employee admin = adminRepository.findById(sanctionLeaveDto.getAdminId())
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", sanctionLeaveDto.getAdminId()));

        SanctionLeave sanctionLeave = SanctionLeaveMapper.mapSancDtoToSanc(sanctionLeaveDto, leaveApplication, compensatoryLeave, admin);

        sanctionLeaveRepository.save(sanctionLeave);

        return SanctionLeaveMapper.mapSancToSancDto(sanctionLeave);
    }

    @Override
    public List<SanctionLeaveDto> getALlSanctionedLeaves() {
        return sanctionLeaveRepository.findAll()
                .stream()
                .map(SanctionLeaveMapper::mapSancToSancDto)
                .toList();
    }

    @Override
    public SanctionLeaveDto getSanctionLeaveById(int id) {
        SanctionLeave sanctionLeave = sanctionLeaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sanction Leave", "sanction leave id", id));
        return SanctionLeaveMapper.mapSancToSancDto(sanctionLeave);
    }

    @Override
    @Transactional
    public String deleteSanctionLeaveById(int id) {
        SanctionLeave sanctionLeave = sanctionLeaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sanction Leave", "Sanction Leave id", id));
        if (sanctionLeave == null) {
            return "Sanction leave with sanction id : " + id + " is not found in the database";
        }
        sanctionLeaveRepository.delete(sanctionLeave);
        return "Sanction leave with sanction id : " + id + " is successfully deleted in the database";
    }
}
