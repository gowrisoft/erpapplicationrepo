package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.dto.BiometricPunchingReportDto;
import com.gentech.erp.hr.entity.BiometricPunchingReport;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.BiometricPunchingReportMapper;
import com.gentech.erp.hr.repository.BiometricPunchingReportRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.BiometricPunchingReportService;

@Service
public class BiometricPunchingReportServiceImpl implements BiometricPunchingReportService{

    @Autowired
    private BiometricPunchingReportRepository biometricpunchingreportRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public BiometricPunchingReportDto createBiometricPunchingReport(
            BiometricPunchingReportDto biometricPunchingReportDto) {
        BiometricPunchingReport biometricPunchingReport = BiometricPunchingReportMapper.mapBiometricPunchingReportDtoToBiometricPunchingReport(biometricPunchingReportDto);
        biometricpunchingreportRepo.save(biometricPunchingReport);
        return BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(biometricPunchingReport);
    }


    @Override
    public List<BiometricPunchingReportDto> getAllBiometricPunchingReport() {
        return biometricpunchingreportRepo.findAll().
                stream().map((biometricPunchingReport)->BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(biometricPunchingReport))
                .toList();
    }


    @Override
    public void deleteBiometricPunchingReportById(Long id) {
        if (!biometricpunchingreportRepo.existsById(id)) {
            throw new ResourceNotFoundException("Admin record not found with id: " + id);
        }
        biometricpunchingreportRepo.deleteById(id);

    }


    @Override
    public BiometricPunchingReportDto getBiometricPunchingReportById(Long id) {
        BiometricPunchingReport biometricPunchingReport = biometricpunchingreportRepo.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Biometric Report", "Biometric Report ID", id));
        return BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(biometricPunchingReport);
    }


    @Override
    public BiometricPunchingReportDto updateBiometricPunchingReport(Long id,
                                                                    BiometricPunchingReportDto biometricpunchingreportDto) {
        BiometricPunchingReport existingBiometricPunchingReport = biometricpunchingreportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "Attendance ID", id));

        existingBiometricPunchingReport.setEmpName(biometricpunchingreportDto.getEmpName());
        existingBiometricPunchingReport.setDate(biometricpunchingreportDto.getDate());
        existingBiometricPunchingReport.setTimeIn(biometricpunchingreportDto.getTimeIn());
        existingBiometricPunchingReport.setTimeOut(biometricpunchingreportDto.getTimeOut());
        existingBiometricPunchingReport.setNumOfPunches(biometricpunchingreportDto.getNumOfPunches());
        existingBiometricPunchingReport.setLocation(biometricpunchingreportDto.getLocation());
        existingBiometricPunchingReport.setDesignation(biometricpunchingreportDto.getDesignation());


        if (biometricpunchingreportDto.getEmployee() != null && biometricpunchingreportDto.getEmployee().getEmpId() != null) {
            Employee employee = employeeRepo.findById(biometricpunchingreportDto.getEmployee().getEmpId())
                    .orElseThrow(() -> new ResourceNotFoundException("Attendance", "Attendance ID",
                            biometricpunchingreportDto.getEmployee().getEmpId()));
            existingBiometricPunchingReport.setEmployee(employee);
        }

        BiometricPunchingReport updatedBiometricPunchingReport = biometricpunchingreportRepo.save(existingBiometricPunchingReport);
        return BiometricPunchingReportMapper.mapBiometricPunchingReportToBiometricPunchingReportDto(updatedBiometricPunchingReport);
    }


}
