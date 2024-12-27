package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.entity.Admin;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.SanctionLeave;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.SanctionLeaveMapper;
import com.gentech.erp.hr.repository.AdminRepository;
import com.gentech.erp.hr.repository.LeaveApplicationRepository;
import com.gentech.erp.hr.repository.SanctionLeaveRepository;
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
    private AdminRepository adminRepository;
    @Autowired
    private SanctionLeaveRepository sanctionLeaveRepository;

    @Override
    public SanctionLeaveDto addSanctionLeave(SanctionLeaveDto sanctionLeaveDto) {
        LeaveApplication leaveApplication = leaveRepository.findById(sanctionLeaveDto.getLeaveRequestId()).
                orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", sanctionLeaveDto.getSanctionId()));

        Admin admin = adminRepository.findById(sanctionLeaveDto.getAdminId()).
                orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", sanctionLeaveDto.getAdminId()));

        SanctionLeave sanctionLeave = SanctionLeaveMapper.mapSancDtoToSanc(sanctionLeaveDto, leaveApplication, admin);
        sanctionLeaveRepository.save(sanctionLeave);
        SanctionLeaveDto sanctionLeaveDto1 = SanctionLeaveMapper.mapSancToSancDto(sanctionLeave);
        return sanctionLeaveDto1;
    }

    @Override
    public List<SanctionLeaveDto> getALlSanctionedLeaves() {
        return sanctionLeaveRepository.findAll()
                .stream()
                .map((sanctionedLeave) -> SanctionLeaveMapper.mapSancToSancDto(sanctionedLeave))
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
        LeaveApplication leaveApplication = sanctionLeave.getLeaveApplication();
        if (leaveApplication != null) {
            leaveApplication.setSanctionLeave(null);
        }
        Admin admin = sanctionLeave.getAdmin();
        if (admin != null) {
            admin.getSanctionLeaves().remove(sanctionLeave);
        }
        sanctionLeaveRepository.delete(sanctionLeave);
        return "Sanction leave with sanction id : " + id + " is successfully deleted in the database";
    }
}

