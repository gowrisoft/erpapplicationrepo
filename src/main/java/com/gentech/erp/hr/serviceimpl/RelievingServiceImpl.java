package com.gentech.erp.hr.serviceimpl;

import java.util.List;
import com.gentech.erp.hr.dto.RelievingReportDto;
import com.gentech.erp.hr.mapper.RelievingReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gentech.erp.hr.entity.RelievingReport;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.repository.RelievingRepository;
import com.gentech.erp.hr.service.RelievingService;
@Service
public class RelievingServiceImpl implements RelievingService{

    @Autowired
    private RelievingRepository relievingRepo;

    @Override
    public RelievingReportDto createRelievingReport(RelievingReportDto relievingDto) {
        RelievingReport relievingReport= RelievingReportMapper.mapRelReportDtoToRelReport(relievingDto);
        relievingRepo.save(relievingReport);
        return RelievingReportMapper.mapRelReportToRelReportDto(relievingReport);
    }

    @Override
    public List<RelievingReportDto> getAllRelievingReports() {
        return relievingRepo.findAll()
                .stream().map((relieving)->RelievingReportMapper.mapRelReportToRelReportDto(relieving))
                .toList();
    }

    @Override
    public RelievingReportDto getRelievingReportById(Long id) {
        RelievingReport relievingReport = relievingRepo.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
        return RelievingReportMapper.mapRelReportToRelReportDto(relievingReport);
    }

    @Override
    public RelievingReportDto updateRelievingReport(Long id, RelievingReportDto relievingDto) {
        RelievingReport existingReport = relievingRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Relieving Report", "Relieving ID", id));

        // Set the new values from the DTO
        existingReport.setRelievingId(id);  // Ensure the ID is preserved
        existingReport.setEmpName(relievingDto.getEmpName());
        existingReport.setDesignation(relievingDto.getDesignation());
        existingReport.setRelievingEmployee(relievingDto.getRelievingEmployee());
        existingReport.setReason(relievingDto.getReason());
        existingReport.setStatus(relievingDto.getStatus());
        existingReport.setRelievingDate(relievingDto.getRelievingDate());
        existingReport.setReladminId(relievingDto.getReladminId());

        // Save the updated report
        RelievingReport updatedReport = relievingRepo.save(existingReport);

        // Return the updated DTO
        return RelievingReportMapper.mapRelReportToRelReportDto(updatedReport);
    }

    @Override
    public void deleteRelievingReportById(Long id) {
        relievingRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Relieving Report", "Relieving ID", id));
        relievingRepo.deleteById(id);

    }


}
