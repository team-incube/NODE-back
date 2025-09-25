package com.example.nodelogin.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "my_secret_key_for_jwt_which_is_long_enough";
    private final long EXPIRATION = 1000L * 60 * 60;

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 토큰 생성
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰에서 email 추출
    public String getEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("토큰 만료: " + e.getMessage());
        } catch (JwtException e) {
            System.out.println("토큰 유효하지 않음: " + e.getMessage());
        }
        return false;
    }
}
