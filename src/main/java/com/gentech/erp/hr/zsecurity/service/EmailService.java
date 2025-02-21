package com.gentech.erp.hr.zsecurity.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String email, String token) {
        String verificationUrl = "http://localhost:3000/verify-email?token=" + token;

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Verify Your Email within 24 hours");
        mailMessage.setText("Click the link to verify your email: " + verificationUrl);

        mailSender.send(mailMessage);
    }

    public void sendPasswordResetEmail(String to, String resetToken) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String resetLink = "http://localhost:3000/reset-password?token=" + resetToken;

            helper.setTo(to);
            helper.setSubject("Password Reset Request");
            helper.setText("Click the link below to reset your password:\n" + resetLink, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
