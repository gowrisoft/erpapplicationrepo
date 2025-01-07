package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.JoiningReportDto;
import com.gentech.erp.hr.entity.JoiningReport;
import com.gentech.erp.hr.mapper.JoiningReportMapper;
import com.gentech.erp.hr.repository.JoiningRepository;
import com.gentech.erp.hr.service.JoiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JoiningSeviceImpl implements JoiningService {

    @Autowired
    private JoiningRepository joiningRepo;

    @Override
    public JoiningReportDto createJoiningReport(JoiningReportDto joiningDto) {
        JoiningReport joiningReport = JoiningReportMapper.mapJoinDtoToJoin(joiningDto);
        joiningRepo.save(joiningReport);
        return JoiningReportMapper.mapJoinToJoinDto(joiningReport);
    }

    @Override
    public List<JoiningReportDto> getAllJoiningReports() {
        return joiningRepo.findAll()
                .stream().map((joining) -> JoiningReportMapper.mapJoinToJoinDto(joining))
                .toList();
    }

}
