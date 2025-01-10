package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.LeaveApplicationDto;
import com.gentech.erp.hr.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class LeaveApplicationController {
    @Autowired
    private LeaveApplicationService leaveService;

    @PostMapping("/addLeave")
    ResponseEntity<LeaveApplicationDto> applyLeave(@RequestBody LeaveApplicationDto leaveDto) {
        return new ResponseEntity<LeaveApplicationDto>(leaveService.addLeave(leaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllLeaves")
    ResponseEntity<List<LeaveApplicationDto>> getAllLeaves() {
        return new ResponseEntity<List<LeaveApplicationDto>>(leaveService.getAllLeaves(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeaveById")
    ResponseEntity<LeaveApplicationDto> getLeaveById(@RequestParam int id) {
        return new ResponseEntity<LeaveApplicationDto>(leaveService.getLeaveById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeaveIdByEmployeeId")
    ResponseEntity<List<Integer>> getLeaveApplicationIdByEmployeeId(@RequestParam long id){
        return new ResponseEntity<List<Integer>>(leaveService.getLeaveApplicationIdByEmployeeId(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeavesByEmployeeId")
    ResponseEntity<List<LeaveApplicationDto>> getLeaveApplicationsByEmployeeId(@RequestParam long id){
        return new ResponseEntity<List<LeaveApplicationDto>>(leaveService.getLeaveApplicationByEmployeeId(id),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updateLeaves")
    ResponseEntity<LeaveApplicationDto> updateLeaveById(@RequestParam int id, @RequestBody LeaveApplicationDto leaveDto) {
        return new ResponseEntity<LeaveApplicationDto>(leaveService.updateLeaveApplication(id,leaveDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteLeaveById")
    ResponseEntity<String> deleteLeaveById(int id) {
        return new ResponseEntity<String>(leaveService.deleteLeaveById(id), HttpStatusCode.valueOf(200));
    }
}
