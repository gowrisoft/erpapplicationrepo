package com.gentech.erp.hr.zsecurity.service;

import com.gentech.erp.hr.zsecurity.entity.MyUser;
import com.gentech.erp.hr.zsecurity.repository.MyUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class JwtService {
    private static final String secret = "09C9CAD1E5F2EAD707158862AE481C8FB3ACB79257B09E25520D0E03F8C813B2310A6ACA1F9F1F2D892CA9AC30E5DE05A210704F7C55DFF5B0BA3486508AF4EA";
    private static final long validity = TimeUnit.MINUTES.toMillis(300);

    @Autowired
    private MyUserRepository myUserRepository;

    public String generateToken(UserDetails userDetails) {
        MyUser user = myUserRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, String> claims = new HashMap<>();
        claims.put("employeeId", String.valueOf(user.getEmployee().getEmpId()));

        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(validity)))
                .signWith(generateKey())
                .compact();
    }

    public SecretKey generateKey() {
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public String extractUser(String jwt) {
        Claims claims = Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        return claims.getSubject();
    }

    public Long extractEmployeeId(String jwt) {
        Object employeeId = Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .get("employeeId");

        return Long.parseLong(employeeId.toString());
    }

    public boolean isTokenValid(String jwt) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(generateKey())
                    .build()
                    .parseSignedClaims(jwt)
                    .getPayload();
            return claims.getExpiration().after(Date.from(Instant.now()));
        } catch (Exception e) {
            return false;
        }
    }
}
