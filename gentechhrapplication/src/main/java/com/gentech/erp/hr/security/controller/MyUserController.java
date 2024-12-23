package com.gentech.erp.hr.security.controller;

import com.gentech.erp.hr.security.entity.MyUser;
import com.gentech.erp.hr.security.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    @Autowired
    private MyUserService service;

    @PostMapping("/register")
    public ResponseEntity<MyUser> registerUser(@RequestBody MyUser user) {
        MyUser registeredUser = service.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}
