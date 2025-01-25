
package com.gentech.erp.hr.serviceimpl;

import java.util.List;

import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.dto.JoiningReportDto;
import com.gentech.erp.hr.mapper.JoiningReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.JoiningReport;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.JoiningRepository;
import com.gentech.erp.hr.service.JoiningService;
@Service  
public class JoiningSeviceImpl implements JoiningService{

	@Autowired
	private JoiningRepository joiningRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public JoiningReportDto createJoiningReport(JoiningReportDto joiningDto) {
	    JoiningReport joiningReport = JoiningReportMapper.mapJoinDtoToJoin(joiningDto);
	    if (joiningDto.getJoiningEmployee() != null && joiningDto.getJoiningEmployee().getEmpId() != null) {
	        Employee employee = employeeRepo.findById(joiningDto.getJoiningEmployee().getEmpId())
	                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Emp ID", joiningDto.getJoiningEmployee().getEmpId()));
	        joiningReport.setJoiningEmployee(employee);
	    }
	    joiningRepo.save(joiningReport);
	    return JoiningReportMapper.mapJoinToJoinDto(joiningReport);
	}


	@Override
	public List<JoiningReportDto> getAllJoiningReports() {
		return joiningRepo.findAll()
				.stream().map((joining)->JoiningReportMapper.mapJoinToJoinDto(joining))
				.toList();
	}

	@Override
	public JoiningReportDto getJoiningReportById(Long id) {
		JoiningReport joiningReport = joiningRepo.findById((long) id)
				 .orElseThrow(() -> new ResourceNotFoundException("Joining Report", "Joining ID", id));
		    return JoiningReportMapper.mapJoinToJoinDto(joiningReport);
	}

	@Override
	public JoiningReportDto updateJoiningReport(Long id, JoiningReportDto joiningDto) {
	    JoiningReport existingReport = joiningRepo.findById(id).orElseThrow(() ->
	            new ResourceNotFoundException("Joining Report", "Joining ID", id));

	    existingReport.setFirstName(joiningDto.getFirstName());
	    existingReport.setLastName(joiningDto.getLastName());
	    existingReport.setDesignation(joiningDto.getDesignation());
	    existingReport.setBaseSalary(joiningDto.getBaseSalary());
	    existingReport.setDateOfJoining(joiningDto.getDateOfJoining());
	    existingReport.setJoinadminId(joiningDto.getJoinadminId());
	    existingReport.setReportingManager(joiningDto.getReportingManager());
	    existingReport.setJoiningEmployee(joiningDto.getJoiningEmployee());



	    JoiningReport updatedReport = joiningRepo.save(existingReport);
	    return JoiningReportMapper.mapJoinToJoinDto(updatedReport);
	}

	@Override
	public void deleteJoiningReportById(Long id) {
		joiningRepo.findById(id).orElseThrow(() ->
		 new ResourceNotFoundException("Joining Report", "Joining ID", id));
		joiningRepo.deleteById(id);
		
	}


	@Override
	public List<JoiningReportDto> getJoiningReportByEmpId(Long employeeId) {
		return joiningRepo.findByJoiningEmployee_EmpId(employeeId)
				.stream().map(report -> JoiningReportMapper.mapJoinToJoinDto(report)).toList();
	}

}
