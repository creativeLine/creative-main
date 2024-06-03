//package com.example.APIGATEWAY.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//public class JwtTest {
//    @Autowired
//    private static JwtUtils jwtUtils;
//
//    public static void main(String[] args) {
//        String username = "testuser";
//        String token = jwtUtils.GenerateToken(username);
//
//        System.out.println("Generated Token: " + token);
//
//        boolean isValid = JwtUtils.validateToken(token);
//        System.out.println("Is token valid? " + isValid);
//
//        Optional<String> extractedUsername = JwtUtils.getUsernameFromToken(token);
//        extractedUsername.ifPresent(s -> System.out.println("Extracted Username: " + s));
//    }
//}
