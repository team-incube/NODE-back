package com.example.nodelogin.security;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final JwtUtil jwtUtil;

    private final long EXPIRE_MS = 1000L * 60 * 60; // 1시간

    public String createToken(String username, String role) {
        return jwtUtil.createJwt(username, role, EXPIRE_MS);
    }

    public boolean validateToken(String token) {
        try {
            return !jwtUtil.isExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return jwtUtil.getUsername(token);
    }

    public String getRole(String token) {
        return jwtUtil.getRole(token);
    }
}
