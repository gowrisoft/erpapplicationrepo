package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.LeaveLedgerDto;
import com.gentech.erp.hr.service.LeaveLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class LeaveLedgerController {
    @Autowired
    private LeaveLedgerService leaveLedgerService;

    @PostMapping("/addLeaveLedger")
    ResponseEntity<LeaveLedgerDto> addLeaveLedger(@RequestBody LeaveLedgerDto leaveLedgerDto) {
        return new ResponseEntity<LeaveLedgerDto>(leaveLedgerService.addLeaveLedger(leaveLedgerDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllLeaveRecords")
    ResponseEntity<List<LeaveLedgerDto>> getAllLeaveLedgerRecords() {
        return new ResponseEntity<List<LeaveLedgerDto>>(leaveLedgerService.getAllLeaveRecords(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeaveRecordById")
    ResponseEntity<LeaveLedgerDto> getLeaveLedgerById(@RequestParam int id) {
        return new ResponseEntity<LeaveLedgerDto>(leaveLedgerService.getLeaveRecordById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getLeaveBalanceById")
    ResponseEntity<Integer> getLeaveBalanceByEmployeeId(@RequestParam long empId) {
        return new ResponseEntity<Integer>(leaveLedgerService.getLeaveBalanceByEmployeeIdInLeaveLedger(empId), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteLeaveLedgerById")
    ResponseEntity<String> deleteLeaveLedgerById(@RequestParam int id) {
        return new ResponseEntity<String>(leaveLedgerService.deleteLeaveLedgerById(id), HttpStatusCode.valueOf(200));
    }
}
