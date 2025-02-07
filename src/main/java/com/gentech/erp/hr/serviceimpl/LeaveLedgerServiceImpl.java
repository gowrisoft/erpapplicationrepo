package com.gentech.erp.hr.serviceimpl;

import com.gentech.erp.hr.dto.LeaveLedgerDto;
import com.gentech.erp.hr.entity.CompensatoryLeave;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.entity.LeaveApplication;
import com.gentech.erp.hr.entity.LeaveLedger;
import com.gentech.erp.hr.exception.ResourceNotFoundException;
import com.gentech.erp.hr.mapper.LeaveLedgerMapper;
import com.gentech.erp.hr.repository.CompensatoryLeaveRepository;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.repository.LeaveApplicationRepository;
import com.gentech.erp.hr.repository.LeaveLedgerRepository;
import com.gentech.erp.hr.service.LeaveLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveLedgerServiceImpl implements LeaveLedgerService {
    @Autowired
    private LeaveLedgerRepository leaveLedgerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LeaveApplicationRepository leaveRepository;
    @Autowired
    private CompensatoryLeaveRepository compensatoryLeaveRepository;

    @Override
    public LeaveLedgerDto addLeaveLedger(LeaveLedgerDto leaveLedgerDto) {
        // Fetch Employee
        Employee employee = employeeRepository.findById(leaveLedgerDto.getEmpId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", leaveLedgerDto.getEmpId()));

        // Optional: Fetch LeaveApplication if leaveRequestId is not null
        LeaveApplication leaveApplication = null;
        if (leaveLedgerDto.getLeaveRequestId() != null) {
            leaveApplication = leaveRepository.findById(leaveLedgerDto.getLeaveRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("Leave Application", "LeaveApplicationId", leaveLedgerDto.getLeaveRequestId()));
        }

        // Optional: Fetch CompensatoryLeave if compensatoryLeaveId is not null
        CompensatoryLeave compensatoryLeaveEntity = null;
        if (leaveLedgerDto.getCompensatoryLeaveId() != null) {
            compensatoryLeaveEntity = compensatoryLeaveRepository.findById(leaveLedgerDto.getCompensatoryLeaveId())
                    .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "CompensatoryLeaveId", leaveLedgerDto.getCompensatoryLeaveId()));
            System.out.println("Fetched CompensatoryLeave: " + compensatoryLeaveEntity);
        }

        // Map DTO to Entity
        LeaveLedger leaveLedger = LeaveLedgerMapper.mapLedgerDtoToLedger(leaveLedgerDto, employee, leaveApplication, compensatoryLeaveEntity);

        // Debug the mapped entity
        System.out.println("Mapped LeaveLedger: " + leaveLedger);

        // Save the entity
        LeaveLedger savedLeaveLedger = leaveLedgerRepository.save(leaveLedger);

        // Map back to DTO with null safety
        LeaveLedgerDto leaveLedgerResponse = LeaveLedgerMapper.mapLedgerToLedgerDto(savedLeaveLedger);

        leaveLedgerResponse.setCompensatoryLeaveId(
                savedLeaveLedger.getCompensatoryLeave() != null
                        ? savedLeaveLedger.getCompensatoryLeave().getCompensatoryLeaveId()
                        : null
        );

        return leaveLedgerResponse;
    }



    @Override
    public List<LeaveLedgerDto> getAllLeaveRecords() {
        return leaveLedgerRepository.findAll()
                .stream()
                .map((leaveLedger) -> LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger))
                .toList();
    }

    @Override
    public LeaveLedgerDto getLeaveRecordById(int id) {
        LeaveLedger leaveLedger = leaveLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave ledger", "ledger id", id));

        return LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger);
    }

    @Override
    public Integer getLeaveBalanceByEmployeeIdInLeaveLedger(long empId) {
        return leaveLedgerRepository.getLeaveBalanceByEmployeeId(empId);
    }

    @Override
    public List<LeaveLedgerDto> getLeaveLedgersWithLeaveApplication() {
        return leaveLedgerRepository.getLeaveLedgersWithLeaveRequestId()
                .stream()
                .map((leaveLedger) -> LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger))
                .toList();
    }

    @Override
    public List<LeaveLedgerDto> getLeaveLedgersWithCompensatoryLeave() {
        return leaveLedgerRepository.getLeaveLedgersWithCompensatoryLeaveId()
                .stream()
                .map((leaveLedger) -> LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger))
                .toList();
    }

    @Transactional
    @Override
    public LeaveLedgerDto updateLeaveLedger(int id, LeaveLedgerDto leaveLedgerDto) {
        // Fetch Leave Ledger
        LeaveLedger leaveLedger = leaveLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave ledger", "ledger id", leaveLedgerDto.getLedgerId()));

        // Fetch Employee
        Employee employee = employeeRepository.findById(leaveLedgerDto.getEmpId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", leaveLedgerDto.getEmpId()));

        // Set Leave Ledger fields
        leaveLedger.setLeaveType(leaveLedgerDto.getLeaveType());
        leaveLedger.setLeaveUsed(leaveLedgerDto.getLeaveUsed());
        leaveLedger.setLeaveBalance(leaveLedgerDto.getLeaveBalance());
        leaveLedger.setStatus(leaveLedgerDto.getStatus());
        leaveLedger.setProcessedBy(leaveLedgerDto.getProcessedBy());

        // Handle CompensatoryLeaveId if not null
        if (leaveLedgerDto.getCompensatoryLeaveId() != null) { // Null-safe check
            CompensatoryLeave compensatoryLeave = compensatoryLeaveRepository.findById(leaveLedgerDto.getCompensatoryLeaveId())
                    .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "CompensatoryLeaveId", leaveLedgerDto.getCompensatoryLeaveId()));
            leaveLedger.setCompensatoryLeave(compensatoryLeave);
        } else {
            leaveLedger.setCompensatoryLeave(null); // Clear the relationship if ID is null
        }

        // Handle LeaveRequestId if not null
        if (leaveLedgerDto.getLeaveRequestId() != null) { // Null-safe check
            LeaveApplication leaveRequest = leaveRepository.findById(leaveLedgerDto.getLeaveRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("Leave Request", "LeaveRequestId", leaveLedgerDto.getLeaveRequestId()));
            leaveLedger.setLeaveApplication(leaveRequest);
        } else {
            leaveLedger.setLeaveApplication(null); // Clear the relationship if ID is null
        }

        // Save the updated LeaveLedger
        LeaveLedger updatedLeaveLedger = leaveLedgerRepository.save(leaveLedger);

        // Return the updated DTO
        LeaveLedgerDto updatedDto = LeaveLedgerMapper.mapLedgerToLedgerDto(updatedLeaveLedger);

        // Null-safe check for CompensatoryLeaveId in the DTO
        if (updatedLeaveLedger.getCompensatoryLeave() != null) {
            updatedDto.setCompensatoryLeaveId(updatedLeaveLedger.getCompensatoryLeave().getCompensatoryLeaveId());
        } else {
            updatedDto.setCompensatoryLeaveId(null); // Set to null if no CompensatoryLeave
        }

        // Null-safe check for LeaveRequestId in the DTO
        if (updatedLeaveLedger.getLeaveApplication() != null) {
            updatedDto.setLeaveRequestId(updatedLeaveLedger.getLeaveApplication().getLeaveRequestId());
        } else {
            updatedDto.setLeaveRequestId(null); // Set to null if no LeaveApplication
        }

        return updatedDto;
    }

    @Override
    public LeaveLedgerDto updateLeaveLedgerByLeaveRequestId(int id, LeaveLedgerDto leaveLedgerDto) {
        // Fetch Leave Ledger
        LeaveLedger leaveLedger = leaveLedgerRepository.findByLeaveRequestId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave ledger", "leave request id", id));

        // Fetch Employee
        Employee employee = employeeRepository.findById(leaveLedgerDto.getEmpId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", leaveLedgerDto.getEmpId()));

        // Set Leave Ledger fields
        leaveLedger.setLeaveType(leaveLedgerDto.getLeaveType());
        leaveLedger.setLeaveUsed(leaveLedgerDto.getLeaveUsed());
        leaveLedger.setLeaveBalance(leaveLedgerDto.getLeaveBalance());
        leaveLedger.setStatus(leaveLedgerDto.getStatus());
        leaveLedger.setProcessedBy(leaveLedgerDto.getProcessedBy());

        // Handle CompensatoryLeaveId if not null
        if (leaveLedgerDto.getCompensatoryLeaveId() != null) { // Null-safe check
            CompensatoryLeave compensatoryLeave = compensatoryLeaveRepository.findById(leaveLedgerDto.getCompensatoryLeaveId())
                    .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "CompensatoryLeaveId", leaveLedgerDto.getCompensatoryLeaveId()));
            leaveLedger.setCompensatoryLeave(compensatoryLeave);
        } else {
            leaveLedger.setCompensatoryLeave(null); // Clear the relationship if ID is null
        }

        // Handle LeaveRequestId if not null
        if (leaveLedgerDto.getLeaveRequestId() != null) { // Null-safe check
            LeaveApplication leaveRequest = leaveRepository.findById(leaveLedgerDto.getLeaveRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("Leave Request", "LeaveRequestId", leaveLedgerDto.getLeaveRequestId()));
            leaveLedger.setLeaveApplication(leaveRequest);
        } else {
            leaveLedger.setLeaveApplication(null); // Clear the relationship if ID is null
        }

        // Save the updated LeaveLedger
        LeaveLedger updatedLeaveLedger = leaveLedgerRepository.save(leaveLedger);

        // Return the updated DTO
        LeaveLedgerDto updatedDto = LeaveLedgerMapper.mapLedgerToLedgerDto(updatedLeaveLedger);

        // Null-safe check for CompensatoryLeaveId in the DTO
        if (updatedLeaveLedger.getCompensatoryLeave() != null) {
            updatedDto.setCompensatoryLeaveId(updatedLeaveLedger.getCompensatoryLeave().getCompensatoryLeaveId());
        } else {
            updatedDto.setCompensatoryLeaveId(null); // Set to null if no CompensatoryLeave
        }

        // Null-safe check for LeaveRequestId in the DTO
        if (updatedLeaveLedger.getLeaveApplication() != null) {
            updatedDto.setLeaveRequestId(updatedLeaveLedger.getLeaveApplication().getLeaveRequestId());
        } else {
            updatedDto.setLeaveRequestId(null); // Set to null if no LeaveApplication
        }

        return updatedDto;
    }

    @Override
    public LeaveLedgerDto updateLeaveLedgerByCompensatoryLeaveId(int id, LeaveLedgerDto leaveLedgerDto) {
        // Fetch Leave Ledger
        LeaveLedger leaveLedger = leaveLedgerRepository.findByCompensatoryLeaveId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave ledger", "leave request id", id));

        // Fetch Employee
        Employee employee = employeeRepository.findById(leaveLedgerDto.getEmpId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", leaveLedgerDto.getEmpId()));

        // Set Leave Ledger fields
        leaveLedger.setLeaveType(leaveLedgerDto.getLeaveType());
        leaveLedger.setLeaveUsed(leaveLedgerDto.getLeaveUsed());
        leaveLedger.setLeaveBalance(leaveLedgerDto.getLeaveBalance());
        leaveLedger.setStatus(leaveLedgerDto.getStatus());
        leaveLedger.setProcessedBy(leaveLedgerDto.getProcessedBy());

        // Handle CompensatoryLeaveId if not null
        if (leaveLedgerDto.getCompensatoryLeaveId() != null) { // Null-safe check
            CompensatoryLeave compensatoryLeave = compensatoryLeaveRepository.findById(leaveLedgerDto.getCompensatoryLeaveId())
                    .orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "CompensatoryLeaveId", leaveLedgerDto.getCompensatoryLeaveId()));
            leaveLedger.setCompensatoryLeave(compensatoryLeave);
        } else {
            leaveLedger.setCompensatoryLeave(null); // Clear the relationship if ID is null
        }

        // Handle LeaveRequestId if not null
        if (leaveLedgerDto.getLeaveRequestId() != null) { // Null-safe check
            LeaveApplication leaveRequest = leaveRepository.findById(leaveLedgerDto.getLeaveRequestId())
                    .orElseThrow(() -> new ResourceNotFoundException("Leave Request", "LeaveRequestId", leaveLedgerDto.getLeaveRequestId()));
            leaveLedger.setLeaveApplication(leaveRequest);
        } else {
            leaveLedger.setLeaveApplication(null); // Clear the relationship if ID is null
        }

        // Save the updated LeaveLedger
        LeaveLedger updatedLeaveLedger = leaveLedgerRepository.save(leaveLedger);

        // Return the updated DTO
        LeaveLedgerDto updatedDto = LeaveLedgerMapper.mapLedgerToLedgerDto(updatedLeaveLedger);

        // Null-safe check for CompensatoryLeaveId in the DTO
        if (updatedLeaveLedger.getCompensatoryLeave() != null) {
            updatedDto.setCompensatoryLeaveId(updatedLeaveLedger.getCompensatoryLeave().getCompensatoryLeaveId());
        } else {
            updatedDto.setCompensatoryLeaveId(null); // Set to null if no CompensatoryLeave
        }

        // Null-safe check for LeaveRequestId in the DTO
        if (updatedLeaveLedger.getLeaveApplication() != null) {
            updatedDto.setLeaveRequestId(updatedLeaveLedger.getLeaveApplication().getLeaveRequestId());
        } else {
            updatedDto.setLeaveRequestId(null); // Set to null if no LeaveApplication
        }

        return updatedDto;
    }

    @Override
    public List<LeaveLedgerDto> getAllLeaveLedgerByEmployeeId(long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", empId));

        List<LeaveLedger> leaveLedgers = leaveLedgerRepository.getLeavesByEmployeeId(empId);

        return leaveLedgers.stream()
                .map((leaveLedger) -> LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger))
                .toList();
    }

    @Override
    @Transactional
    public String deleteLeaveLedgerById(int id) {
        LeaveLedger leaveLedger = leaveLedgerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave ledger", "leave ledger id", id));
        if (leaveLedger == null) {
            return "Leave Ledger with ledger id : " + id + " is not found in the database";
        }
        Employee employee = leaveLedger.getEmployee();
        if (employee != null) {
            employee.getLeaveLedgers().remove(leaveLedger);
        }
        LeaveApplication leaveApplication = leaveLedger.getLeaveApplication();
        if (leaveApplication != null) {
            leaveApplication.setLeaveLedger(null);
        }
        CompensatoryLeave compensatoryLeave = leaveLedger.getCompensatoryLeave();
        if (compensatoryLeave != null) {
            compensatoryLeave.setLeaveLedger(null);
        }
        leaveLedgerRepository.delete(leaveLedger);
        return "Leave ledger with ledger id : " + id + " is successfully deleted in database";
    }
}