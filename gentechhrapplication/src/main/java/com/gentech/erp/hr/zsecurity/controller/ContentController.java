package com.gentech.erp.hr.zsecurity.controller;

import com.gentech.erp.hr.zsecurity.serviceimpl.MyUserDetailsServiceImpl;
import com.gentech.erp.hr.zsecurity.service.JwtService;
import com.gentech.erp.hr.zsecurity.entity.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsServiceImpl;

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailsServiceImpl.loadUserByUsername(loginForm.username()));
        } else {
            throw new UsernameNotFoundException("Invalid Credentails!!!");
        }
    }
}