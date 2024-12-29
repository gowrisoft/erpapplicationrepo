package com.gentech.erp.hr.zsecurity.service;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.exception.EmptyUsernameException;
import com.gentech.erp.hr.exception.UsernameAlreadyExistsException;
import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    public MyUserDto registerUser(MyUserDto userDto) {
        MyUser user = modelMapper.map(userDto, MyUser.class);
        if (!StringUtils.hasText(user.getUsername())) {
            throw new EmptyUsernameException("Username cannot be empty");
        }
        if (repository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return modelMapper.map(user, MyUserDto.class);
    }
}
