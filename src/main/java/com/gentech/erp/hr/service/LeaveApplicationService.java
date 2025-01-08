package com.gentech.erp.hr.service;

import com.gentech.erp.hr.dto.LeaveApplicationDto;

import java.util.List;

public interface LeaveApplicationService {
    LeaveApplicationDto addLeave(LeaveApplicationDto leaveDto);

    List<LeaveApplicationDto> getAllLeaves();

    LeaveApplicationDto getLeaveById(int id);

    String deleteLeaveById(int id);

    List<Integer> getLeaveApplicationIdByEmployeeId(long id);

    List<LeaveApplicationDto> getLeaveApplicationByEmployeeId(long id);

    List<Object[]> getLeaveDetails();
}