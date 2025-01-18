package com.gentech.erp.hr.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.dto.AttendanceDto;
import com.gentech.erp.hr.entity.Attendance;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.AttendanceMapper;
import com.gentech.erp.hr.repository.AttendanceRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public AttendanceDto createAttendance(AttendanceDto attendanceDto) {
		Attendance attendance = AttendanceMapper.mapAttendanceDtoToAttendance(attendanceDto);
		attendanceRepo.save(attendance);
		return AttendanceMapper.mapAttendanceToAttendanceDto(attendance);
	}

	@Override
	public List<AttendanceDto> getAllAttendance() {
		return attendanceRepo.findAll().stream()
				.map((attendance) -> AttendanceMapper.mapAttendanceToAttendanceDto(attendance)).toList();
	}

	@Override
	public void deleteAttendanceById(Long id) {
		if (!attendanceRepo.existsById(id)) {
			throw new ResourceNotFoundException("Attendance record not found with id: " + id);
		}
		attendanceRepo.deleteById(id);
	}

	@Override
	public AttendanceDto getAttendanceById(Long id) {
		Attendance attendance = attendanceRepo.findById((long) id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance", "Attendance ID", id));
		return AttendanceMapper.mapAttendanceToAttendanceDto(attendance);
	}

	@Override
	public AttendanceDto updateAttendance(Long id, AttendanceDto attendanceDto) {
		Attendance existingAttendance = attendanceRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Attendance", "Attendance ID", id));

		existingAttendance.setAttendanceDate(attendanceDto.getAttendanceDate());
		existingAttendance.setAttendanceStatus(attendanceDto.getAttendanceStatus());
		

		if (attendanceDto.getEmployee() != null && attendanceDto.getEmployee().getEmpId() != null) {
			Employee employee = employeeRepo.findById(attendanceDto.getEmployee().getEmpId())
					.orElseThrow(() -> new ResourceNotFoundException("Attendance", "Attendance ID",
							attendanceDto.getEmployee().getEmpId()));
			existingAttendance.setEmployee(employee);
		}

		Attendance updatedAttendance = attendanceRepo.save(existingAttendance);
		return AttendanceMapper.mapAttendanceToAttendanceDto(updatedAttendance);
	}

	@Override
	public List<AttendanceDto> getAttendanceByEmployeeId(Long employeeId) {
		 // Fetch attendance records for the given employee ID
	    List<Attendance> attendanceList = attendanceRepo.findByEmployeeEmpId(employeeId);

	    // Map the attendance records to DTOs and return
	    return attendanceList.stream()
	            .map(AttendanceMapper::mapAttendanceToAttendanceDto)
	            .collect(Collectors.toList());
	}

}
