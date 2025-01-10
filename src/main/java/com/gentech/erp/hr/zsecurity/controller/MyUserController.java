package com.gentech.erp.hr.zsecurity.controller;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.zsecurity.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class MyUserController {

    @Autowired
    private MyUserService service;

    @PostMapping("/register")
    public ResponseEntity<MyUserDto> registerUser(@RequestBody MyUserDto user) {
        return new ResponseEntity<>(service.registerUser(user), HttpStatus.CREATED);
    }
}