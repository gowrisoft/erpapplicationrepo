package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.RegisterRelievingReportsDto;
import com.gentech.erp.hr.entity.RegisterRelievingReports;
import com.gentech.erp.hr.mapper.RegisterRelievingReportsMapper;
import com.gentech.erp.hr.repository.RegisterRelievingRepository;
import com.gentech.erp.hr.service.RegisterRelievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegisterRelievingServiceImpl implements RegisterRelievingService {

    @Autowired
    private RegisterRelievingRepository registerRepo;

    @Override
    public RegisterRelievingReportsDto createRegisterReport(RegisterRelievingReportsDto registerDto) {
        RegisterRelievingReports registerRelievingReports = RegisterRelievingReportsMapper.mapRegRelDtoToRegRel(registerDto);
        registerRepo.save(registerRelievingReports);
        return RegisterRelievingReportsMapper.mapRegRelToRegRelDto(registerRelievingReports);
    }

    @Override
    public List<RegisterRelievingReportsDto> getAllRegisterReports() {
        return registerRepo.findAll()
                .stream().map((regRelieving) -> RegisterRelievingReportsMapper.mapRegRelToRegRelDto(regRelieving))
                .toList();
    }
}
