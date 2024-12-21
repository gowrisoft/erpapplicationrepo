package com.gentech.erp.hr.security.controller;

import com.gentech.erp.hr.security.entity.MyUser;
import com.gentech.erp.hr.security.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    @Autowired
    private MyUserService service;

    @PostMapping("/register")
    public MyUser registerUser(@RequestBody MyUser user)
    {
        return service.registerUser(user);
    }
}
