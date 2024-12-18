package com.gentech.erp.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.erp.hr.dto.LeaveApplicationDto;
import com.gentech.erp.hr.service.LeaveApplicationService;

@RestController
@RequestMapping("/v1/api")
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveService;
    @PostMapping("/addLeave")
    ResponseEntity<LeaveApplicationDto> applyLeave(@RequestBody LeaveApplicationDto leaveDto){
        return new ResponseEntity<LeaveApplicationDto>(leaveService.addLeave(leaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllLeaves")
    ResponseEntity<List<LeaveApplicationDto>> getAllLeaves(){
        return new ResponseEntity<List<LeaveApplicationDto>>(leaveService.getAllLeaves(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeaveById")
    ResponseEntity<LeaveApplicationDto> getLeaveById(@RequestParam int id){
        return new ResponseEntity<LeaveApplicationDto>(leaveService.getLeaveById(id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteLeaveById")
    ResponseEntity<String> deleteLeaveById(int id){
        return new ResponseEntity<String>(leaveService.deleteLeaveById(id),HttpStatusCode.valueOf(200));
    }
}
