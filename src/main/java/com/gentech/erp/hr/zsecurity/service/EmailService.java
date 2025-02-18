package com.gentech.erp.hr.zsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String email, String token) {
        String verificationUrl = "http://localhost:9091/v1/api/auth/verify-email?token=" + token;

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Verify Your Email within 24 hours");
        mailMessage.setText("Click the link to verify your email: " + verificationUrl);

        mailSender.send(mailMessage);
    }
}
