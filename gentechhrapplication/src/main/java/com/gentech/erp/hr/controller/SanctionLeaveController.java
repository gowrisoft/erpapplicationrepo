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

import com.gentech.erp.hr.dto.SanctionLeaveDto;
import com.gentech.erp.hr.service.SanctionLeaveService;

@RestController
@RequestMapping("/v1/api")
public class SanctionLeaveController {
    @Autowired
    private SanctionLeaveService sanctionLeaveService;
    @PostMapping("/addSanctionLeave")
    ResponseEntity<SanctionLeaveDto> addSanctionLeave(@RequestBody SanctionLeaveDto sanctionLeaveDto){
        return new ResponseEntity<SanctionLeaveDto>(sanctionLeaveService.addSanctionLeave(sanctionLeaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllSanctionedLeaves")
    ResponseEntity<List<SanctionLeaveDto>> getAllSanctionedLeaves(){
        return new ResponseEntity<List<SanctionLeaveDto>>(sanctionLeaveService.getALlSanctionedLeaves(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getSanctionLeaveById")
    ResponseEntity<SanctionLeaveDto> getSanctionLeaveById(@RequestParam int id){
        return new ResponseEntity<SanctionLeaveDto>(sanctionLeaveService.getSanctionLeaveById(id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteSanctionLeaveById")
    ResponseEntity<String> deleteSanctionLeaveById(@RequestParam int id){
        return new ResponseEntity<String>(sanctionLeaveService.deleteSanctionLeaveById(id),HttpStatusCode.valueOf(200));
    }
}
