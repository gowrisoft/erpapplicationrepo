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
        Employee employee = employeeRepository.findById(leaveLedgerDto.getEmpId()).
                orElseThrow(() -> new ResourceNotFoundException("Employee", "EmployeeId", leaveLedgerDto.getEmpId()));

        LeaveApplication leaveApplication = leaveRepository.findById(leaveLedgerDto.getLeaveRequestId()).
                orElseThrow(() -> new ResourceNotFoundException("Leave Application", "LeaveApplicationId", leaveLedgerDto.getLeaveRequestId()));

        CompensatoryLeave compensatoryLeaveEntity = compensatoryLeaveRepository.findById(leaveLedgerDto.getCompensatoryLeaveId()).
                orElseThrow(() -> new ResourceNotFoundException("Compensatory Leave", "CompensatoryLeaveId", leaveLedgerDto.getCompensatoryLeaveId()));

        LeaveLedger leaveLedger = LeaveLedgerMapper.mapLedgerDtoToLedger(leaveLedgerDto, employee, leaveApplication, compensatoryLeaveEntity);
        leaveLedgerRepository.save(leaveLedger);
        LeaveLedgerDto leaveLedgerDto1 = LeaveLedgerMapper.mapLedgerToLedgerDto(leaveLedger);
        return leaveLedgerDto1;
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
            leaveApplication.getLeaveLedgers().remove(leaveLedger);
        }
        CompensatoryLeave compensatoryLeave = leaveLedger.getCompensatoryLeave();
        if (compensatoryLeave != null) {
            compensatoryLeave.setLeaveLedger(null);
        }
        leaveLedgerRepository.delete(leaveLedger);
        return "Leave ledger with ledger id : " + id + " is successfully deleted in database";
    }
}