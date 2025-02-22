package com.gentech.erp.hr.zsecurity.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String email, String token) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String verificationUrl = "http://localhost:3000/verify-email?token=" + token;

            String emailContent = "<div style='font-family: Arial, sans-serif; padding: 20px; color: #333;'>"
                    + "<p>Dear User,</p>"
                    + "<p>Thank you for signing up! Please verify your email within <strong>24 hours</strong> by clicking the button below:</p>"
                    + "<a href='" + verificationUrl + "' style='display: inline-block; background-color: #28a745; color: white; text-decoration: none; padding: 10px 20px; border-radius: 5px; font-size: 16px;'>Verify Email</a>"
                    + "<p>If you did not request this, you can safely ignore this email.</p>"
                    + "<p style='margin-top: 20px;'>Best Regards,<br><strong>Gowri Software Solutions</strong></p>"
                    + "</div>";

            helper.setTo(email);
            helper.setSubject("Verify Your Email within 24 hours");
            helper.setText(emailContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendPasswordResetEmail(String to, String resetToken) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String resetLink = "http://localhost:3000/reset-password?token=" + resetToken;

            String emailContent = "<div style='font-family: Arial, sans-serif; padding: 20px; color: #333;'>"
                    + "<p>Dear User,</p>"
                    + "<p>We received a request to reset your password. Click the button below to reset it:</p>"
                    + "<a href='" + resetLink + "' style='display: inline-block; background-color: #007bff; color: white; text-decoration: none; padding: 10px 20px; border-radius: 5px;'>Reset Password</a>"
                    + "<p>If you did not request this, please ignore this email.</p>"
                    + "<p>Best Regards,<br><strong>Gowri Software Solutions</strong></p>"
                    + "</div>";

            helper.setTo(to);
            helper.setSubject("Password Reset Request");
            helper.setText(emailContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

}
