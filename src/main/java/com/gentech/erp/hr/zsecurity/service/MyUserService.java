package com.gentech.erp.hr.zsecurity.service;

import com.gentech.erp.hr.dto.MyUserDto;
import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.exception.UsernameAlreadyExistsException;
import com.gentech.erp.hr.repository.EmployeeRepository;
import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailService emailService;

    @Transactional
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
        MyUser myUser = repository.save(user);

        String verificationToken = jwtService.generateVerificationToken(user.getEmployee().getEmail());
        emailService.sendVerificationEmail(user.getEmployee().getEmail(), verificationToken, user.getUsername(), userDto.getPassword());

        return modelMapper.map(myUser, MyUserDto.class);
    }

    @Transactional
    public String verifyEmail(String token) {
        if (!jwtService.isTokenValid(token)) {
            throw new IllegalArgumentException("Invalid or expired token.");
        }

        String email = jwtService.getEmailFromVerificationToken(token);
        MyUser user = repository.findByEmployee_Email(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setVerified(true);
        repository.save(user);

        return "Email verified successfully! You can now log in.";
    }

    @Transactional
    public void forgotPassword(String email) {
        if (!repository.existsByEmployee_Email(email)) {
            throw new IllegalArgumentException("User not found");
        }

        String resetToken = jwtService.generateVerificationToken(email);
        emailService.sendPasswordResetEmail(email, resetToken);
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        if (!jwtService.isTokenValid(token)) {
            throw new IllegalArgumentException("Invalid or expired reset token.");
        }

        String email = jwtService.getEmailFromVerificationToken(token);
        MyUser user = repository.findByEmployee_Email(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));
        repository.save(user);
    }
}
