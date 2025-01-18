package com.gentech.erp.hr.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.dto.BiometricAttendanceDto;
import com.gentech.erp.hr.entity.BiometricAttendance;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.BiometricAttendanceMapper;
import com.gentech.erp.hr.repository.BiometricAttendanceRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.BiometricAttendanceService;

@Service
public class BiometricAttendanceServiceImpl implements BiometricAttendanceService{

	@Autowired
	private BiometricAttendanceRepository biometricattendanceRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public BiometricAttendanceDto createBiometricAttendance(BiometricAttendanceDto biometricAttendanceDto) {
		BiometricAttendance biometricAttendance = BiometricAttendanceMapper.mapBiometricAttendanceDtoToBiometricAttendance(biometricAttendanceDto);
		biometricattendanceRepo.save(biometricAttendance);
		return BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(biometricAttendance);
	}

	@Override
	public List<BiometricAttendanceDto> getAllBiometricAttendance() {
		return biometricattendanceRepo.findAll().
				stream().map((biometricAttendance)->BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(biometricAttendance))
				.toList();
	}

	@Override
	public void deleteBiometricAttendanceById(Long id) {
		if (!biometricattendanceRepo.existsById(id)) {
            throw new ResourceNotFoundException("Admin record not found with id: " + id);
        }
		biometricattendanceRepo.deleteById(id);	
		
	}

	@Override
	public BiometricAttendanceDto getBiometricAttendanceById(Long id) {
		BiometricAttendance biometricAttendance = biometricattendanceRepo.findById((long) id)
				.orElseThrow(() -> new ResourceNotFoundException("Biometric Attendance", "Bio Attendance ID", id));
		return BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(biometricAttendance);
	}

	@Override
	public BiometricAttendanceDto updateBiometricAttendance(Long id, BiometricAttendanceDto biometricAttendanceDto) {
		BiometricAttendance existingBiometricAttendance = biometricattendanceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Biometric Attendance", "Bio Attendance ID", id));

		existingBiometricAttendance.setAttendanceDate(biometricAttendanceDto.getAttendanceDate());
		existingBiometricAttendance.setTimeIn(biometricAttendanceDto.getTimeIn());
		existingBiometricAttendance.setTimeOut(biometricAttendanceDto.getTimeOut());
		existingBiometricAttendance.setTotalHoursWorked(biometricAttendanceDto.getTotalHoursWorked());
		existingBiometricAttendance.setDutyType(biometricAttendanceDto.getDutyType());
	
		

		if (biometricAttendanceDto.getEmployee() != null && biometricAttendanceDto.getEmployee().getEmpId() != null) {
			Employee employee = employeeRepo.findById(biometricAttendanceDto.getEmployee().getEmpId())
					.orElseThrow(() -> new ResourceNotFoundException("Biometric Attendance", "Bio Attendance ID",
							biometricAttendanceDto.getEmployee().getEmpId()));
			existingBiometricAttendance.setEmployee(employee);
		}

		BiometricAttendance updatedBiometricAttendance = biometricattendanceRepo.save(existingBiometricAttendance);
		return BiometricAttendanceMapper.mapBiometricAttendanceToBiometricAttendanceDto(updatedBiometricAttendance);
	}

	@Override
	public List<BiometricAttendanceDto> getBiometricAttendanceByEmployeeId(Long employeeId) {
		// Fetch attendance records for the given employee ID
	    List<BiometricAttendance> biometricattendanceList = biometricattendanceRepo.findByEmployeeEmpId(employeeId);

	    // Map the attendance records to DTOs and return
	    return biometricattendanceList.stream()
	            .map(BiometricAttendanceMapper::mapBiometricAttendanceToBiometricAttendanceDto)
	            .collect(Collectors.toList());
	}
	


	
	
}

 