package com.gentech.erp.hr.security.controller;

import com.gentech.erp.hr.security.service.MyUserDetailsService;
import com.gentech.erp.hr.security.webtoken.JwtService;
import com.gentech.erp.hr.security.webtoken.LoginForm;
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
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailsService.loadUserByUsername(loginForm.username()));
        } else {
            throw new UsernameNotFoundException("Invalid Credentails!!!");
        }
    }
}