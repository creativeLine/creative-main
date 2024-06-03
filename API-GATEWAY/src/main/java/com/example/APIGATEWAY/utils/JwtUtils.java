package com.example.APIGATEWAY.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {

//    private static final SecretKey  = Jwts.SIG.HS256.key().build();
    public static final String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
            return claims != null;
        } catch (Exception e) {
            // Log the exception with a meaningful message
            System.err.println("JWT Exception occurred: " + e.getMessage());
            return false;
        }
    }
}
