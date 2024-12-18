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

import com.gentech.erp.hr.dto.AdminDto;
import com.gentech.erp.hr.service.AdminService;

@RestController
@RequestMapping("/v1/api")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/addAdmin")
    ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto){
        return new ResponseEntity<AdminDto>(adminService.addAdmin(adminDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllAdmin")
    ResponseEntity<List<AdminDto>> getAllAdmin(){
        return new ResponseEntity<List<AdminDto>>(adminService.getAllAdmin(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAdminById")
    ResponseEntity<AdminDto> getAdminById(@RequestParam int id){
        return new ResponseEntity<AdminDto>(adminService.getAdminById(id),HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/deleteAdminById")
    ResponseEntity<String> deleteAdminById(@RequestParam int id){
        return new ResponseEntity<String>(adminService.deleteAdminById(id),HttpStatusCode.valueOf(200));
    }
}