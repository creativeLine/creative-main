package com.example.jwtAuthentication.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.Base64;

@Slf4j
public class JwtUtils {

    private JwtUtils(){}

    private static final String ISSUER = "Alok";
    // Ensure that the key used here is the same key used to sign the JWTs
    private static final String SECRET_KEY_STRING = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY_STRING));

    public static boolean validateToken(String jwtToken) {
        return parseToken(jwtToken).isPresent();
    }

    private static Optional<Claims> parseToken(String jwtToken) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();
            return Optional.of(claims);
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT Exception occurred: {}", e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<String> getUsernameFromToken(String jwtToken) {
        return parseToken(jwtToken)
                .map(Claims::getSubject);
    }

    public static String generateToken(String username) {
        Date currentDate = new Date();
        Date expirationDate = DateUtils.addMinutes(currentDate, 10);
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuer(ISSUER)
                .setSubject(username)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .compact();
    }
}
