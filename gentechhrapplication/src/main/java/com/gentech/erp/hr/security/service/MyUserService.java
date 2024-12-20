package com.gentech.erp.hr.security.service;

import com.gentech.erp.hr.security.entity.MyUser;
import com.gentech.erp.hr.security.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


 @Service
public class MyUserService {

    @Autowired
    private MyUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public MyUser registerUser(MyUser user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }


}
