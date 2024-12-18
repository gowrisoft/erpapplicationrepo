package com.gentech.erp.hr.service;

import java.util.List;

import com.gentech.erp.hr.dto.LeaveApplicationDto;

public interface LeaveApplicationService {
    LeaveApplicationDto addLeave(LeaveApplicationDto leaveDto);
    List<LeaveApplicationDto> getAllLeaves();
    LeaveApplicationDto getLeaveById(int id);
    String deleteLeaveById(int id);
}