package com.gentech.erp.hr.security.service;

import com.gentech.erp.hr.exception.EmptyUsernameException;
import com.gentech.erp.hr.exception.UsernameAlreadyExistsException;
import com.gentech.erp.hr.security.entity.MyUser;
import com.gentech.erp.hr.security.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MyUser registerUser(MyUser user) {
        if (!StringUtils.hasText(user.getUsername())) {
            throw new EmptyUsernameException("Username cannot be empty");
        }

        if (repository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }
}
