package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;
import com.gentech.erp.hr.service.CompensatoryLeaveService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CompensatoryLeaveController {
    @Autowired
    private CompensatoryLeaveService compensatoryLeaveService;

    @PostMapping("/user/addCompensatoryLeave")
    ResponseEntity<CompensatoryLeaveDto> addCompensatoryLeave(@RequestBody CompensatoryLeaveDto compensatoryLeaveDto, HttpServletRequest request) {
        compensatoryLeaveDto.setEmpId((long) request.getAttribute("employeeId"));
        return new ResponseEntity<CompensatoryLeaveDto>(compensatoryLeaveService.addCompensatoryLeave(compensatoryLeaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/admin/getAllCompensatoryLeave")
    ResponseEntity<List<CompensatoryLeaveDto>> getAllCompensatoryLeaves() {
        return new ResponseEntity<List<CompensatoryLeaveDto>>(compensatoryLeaveService.getAllCompensatoryLeaves(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/getAllCompensatoryLeave")
    ResponseEntity<List<CompensatoryLeaveDto>> getAllCompensatoryLeave() {
        return new ResponseEntity<List<CompensatoryLeaveDto>>(compensatoryLeaveService.getAllCompensatoryLeaves(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getCompensatoryLeaveById")
    ResponseEntity<CompensatoryLeaveDto> getCompensatoryLeaveById(@RequestParam int id) {
        return new ResponseEntity<CompensatoryLeaveDto>(compensatoryLeaveService.getAllCompensatoryLeaveById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getCompensatoryLeavesByEmployeeId")
    ResponseEntity<List<CompensatoryLeaveDto>> getCompensatoryLeavesByEmployeeId(@RequestParam int id) {
        return new ResponseEntity<List<CompensatoryLeaveDto>>(compensatoryLeaveService.getCompensatoryLeaveByEmployeeId(id), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updateCompensatoryLeave")
    ResponseEntity<CompensatoryLeaveDto> updateCompensatoryLeave(@RequestParam int id, @RequestBody CompensatoryLeaveDto compensatoryLeaveDto) {
        return new ResponseEntity<CompensatoryLeaveDto>(compensatoryLeaveService.updateCompensatoryLeave(id, compensatoryLeaveDto), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteCompensatoryLeaveById")
    ResponseEntity<String> deleteCompensatoryLeaveById(@RequestParam int id) {
        return new ResponseEntity<String>(compensatoryLeaveService.deleteCompensatoryLeaveById(id), HttpStatusCode.valueOf(200));
    }

}