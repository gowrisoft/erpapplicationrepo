package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;
import com.gentech.erp.hr.entity.BiometricAttendance;
import com.gentech.erp.hr.mapper.BiometricAttendanceMapper;
import com.gentech.erp.hr.repository.BiometricAttendanceRepository;
import com.gentech.erp.hr.service.BiometricAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiometricAttendanceServiceImpl implements BiometricAttendanceService {

    @Autowired
    private BiometricAttendanceRepository biometricattendanceRepo;

    @Override
    public BiometricAttendanceDto createBiometricAttendance(BiometricAttendanceDto biometricAttendanceDto) {
        BiometricAttendance biometricAttendance = BiometricAttendanceMapper.mapBiometricAttendanceDtoToBiometricAttendance(biometricAttendanceDto);
        biometricattendanceRepo.save(biometricAttendance);
        return BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(biometricAttendance);
    }

    @Override
    public List<BiometricAttendanceDto> getAllBiometricAttendance() {
        return biometricattendanceRepo.findAll().
                stream().map((biometricAttendance) -> BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(biometricAttendance))
                .toList();
    }


}

 