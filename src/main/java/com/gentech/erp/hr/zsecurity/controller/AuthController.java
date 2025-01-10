package com.gentech.erp.hr.zsecurity.controller;

import com.gentech.erp.hr.zsecurity.entity.LoginForm;
import com.gentech.erp.hr.zsecurity.service.JwtService;
import com.gentech.erp.hr.zsecurity.serviceimpl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/api")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsServiceImpl;

    @PostMapping("/admin/authenticate")
    public String authenticateAdmin(@RequestBody LoginForm loginForm) {
        return authenticateUserWithRole(loginForm, "ROLE_ADMIN");
    }

    @PostMapping("/user/authenticate")
    public String authenticateEmployee(@RequestBody LoginForm loginForm) {
        return authenticateUserWithRole(loginForm, "ROLE_USER");
    }

    private String authenticateUserWithRole(LoginForm loginForm, String role) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));

        if (auth.isAuthenticated()) {
            if (auth.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role))) {
                return jwtService.generateToken(myUserDetailsServiceImpl.loadUserByUsername(loginForm.username()));
            } else {
                throw new UsernameNotFoundException("User does not have the required role: " + role);
            }
        }
        throw new UsernameNotFoundException("Invalid Credentials!!!");
    }
}