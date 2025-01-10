package com.gentech.erp.hr.zsecurity.service;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.EmptyUsernameException;
import com.gentech.erp.hr.exception.UsernameAlreadyExistsException;
import com.gentech.erp.hr.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public MyUserDto registerUser(MyUserDto userDto) {

        if (repository.existsByUsername(userDto.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        MyUser user = new MyUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole().toUpperCase());

        if(userDto.getEmployeeId() != null) {
            Employee employee = employeeRepository.findById(userDto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            if (repository.existsByEmployee(employee)) {
                throw new IllegalArgumentException("Employee is already associated with a user");
            }
            user.setEmployee(employee);
        }

        return modelMapper.map(repository.save(user), MyUserDto.class);
    }
}
