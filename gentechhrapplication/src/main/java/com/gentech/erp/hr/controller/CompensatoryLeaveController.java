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

import com.gentech.erp.hr.dto.CompensatoryLeaveDto;
import com.gentech.erp.hr.service.CompensatoryLeaveService;

@RestController
@RequestMapping("/v1/api")
public class CompensatoryLeaveController {
    @Autowired
    private CompensatoryLeaveService compensatoryLeaveService;
    @PostMapping("/addCompensatoryLeave")
    ResponseEntity<CompensatoryLeaveDto> addCompensatoryLeave(@RequestBody CompensatoryLeaveDto compensatoryLeaveDto){
        return new ResponseEntity<CompensatoryLeaveDto>(compensatoryLeaveService.addCompensatoryLeave(compensatoryLeaveDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllCompensatoryLeave")
    ResponseEntity<List<CompensatoryLeaveDto>> getAllCompensatoryLeaves(){
        return new ResponseEntity<List<CompensatoryLeaveDto>>(compensatoryLeaveService.getAllCompensatoryLeaves(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getCompensatoryLeaveById")
    ResponseEntity<CompensatoryLeaveDto> getCompensatoryLeaveById(@RequestParam int id){
        return new ResponseEntity<CompensatoryLeaveDto>(compensatoryLeaveService.getAllCompensatoryLeaveById(id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteCompensatoryLeaveById")
    ResponseEntity<String> deleteCompensatoryLeaveById(@RequestParam int id){
        return new ResponseEntity<String>(compensatoryLeaveService.deleteCompensatoryLeaveById(id),HttpStatusCode.valueOf(200));
    }
}
