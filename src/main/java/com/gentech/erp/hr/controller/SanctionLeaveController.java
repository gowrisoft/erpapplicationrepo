package com.gentech.erp.hr.controller;

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.service.SanctionLeaveService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class SanctionLeaveController {
    @Autowired
    private SanctionLeaveService sanctionLeaveService;

    @PostMapping("admin/addSanctionLeave")
    ResponseEntity<SanctionLeaveDto> addSanctionLeave(@RequestBody SanctionLeaveDto sanctionLeaveDto, HttpServletRequest request) {
        sanctionLeaveDto.setAdminId((long) request.getAttribute("employeeId"));
        return new ResponseEntity<SanctionLeaveDto>(sanctionLeaveService.addSanctionLeave(sanctionLeaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/admin/getAllSanctionedLeaves")
    ResponseEntity<List<SanctionLeaveDto>> getAllSanctionedLeaves() {
        return new ResponseEntity<List<SanctionLeaveDto>>(sanctionLeaveService.getALlSanctionedLeaves(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getSanctionLeaveById")
    ResponseEntity<SanctionLeaveDto> getSanctionLeaveById(@RequestParam int id) {
        return new ResponseEntity<SanctionLeaveDto>(sanctionLeaveService.getSanctionLeaveById(id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteSanctionLeaveById")
    ResponseEntity<String> deleteSanctionLeaveById(@RequestParam int id) {
        return new ResponseEntity<String>(sanctionLeaveService.deleteSanctionLeaveById(id), HttpStatusCode.valueOf(200));
    }
}
