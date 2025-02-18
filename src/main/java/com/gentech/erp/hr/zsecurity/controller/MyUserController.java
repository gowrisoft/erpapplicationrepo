package com.gentech.erp.hr.zsecurity.controller;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import com.gentech.erp.hr.zsecurity.service.JwtService;
import com.gentech.erp.hr.zsecurity.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/api")
public class MyUserController {

    @Autowired
    private MyUserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserRepository myUserRepository;

    @PostMapping("/register")
    public ResponseEntity<MyUserDto> registerUser(@RequestBody MyUserDto user) {
        return new ResponseEntity<>(service.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/auth/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        try{
            String email = jwtService.getEmailFromVerificationToken(token);
            Optional<MyUser> myUser = myUserRepository.findByEmployee_Email(email);

            if(!myUser.isPresent()) {
                return ResponseEntity.badRequest().body("User not found");
            }

            MyUser user = myUser.get();
            user.setVerified(true);
            myUserRepository.save(user);

            return ResponseEntity.ok("Email verified successfully! You can now log in.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }
}