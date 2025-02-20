package com.gentech.erp.hr.zsecurity.controller;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import com.gentech.erp.hr.zsecurity.service.JwtService;
import com.gentech.erp.hr.zsecurity.service.MyUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/api")
public class MyUserController {

    @Autowired
    private MyUserService userService;

    @PostMapping("/register")
    public ResponseEntity<MyUserDto> registerUser(@RequestBody MyUserDto user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/auth/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        return ResponseEntity.ok(userService.verifyEmail(token));
    }
}