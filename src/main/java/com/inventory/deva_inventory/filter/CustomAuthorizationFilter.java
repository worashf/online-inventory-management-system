///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.inventory.deva_inventory.filter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.util.ArrayList;
//import static java.util.Arrays.stream;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
///**
// *
// * @author mntemnte
// */
//public class CustomAuthorizationFilter  extends OncePerRequestFilter{
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        if (request.getServletPath().equals("/api/login")) {
//            filterChain.doFilter(request, response);
//        } else {
//            String authorizationHeader = request.getHeader(AUTHORIZATION);
//            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//                try {
//                    String token = authorizationHeader.substring("Bearer ".length());
//                    Algorithm algo = Algorithm.HMAC256("secret".getBytes());
//                    JWTVerifier verfier = JWT.require(algo).build();
//                    DecodedJWT decodedJwt = verfier.verify(token);
//                    String userName = decodedJwt.getSubject();
//                    String[] roles = decodedJwt.getClaim("roles").asArray(String.class);
//                    Collection<SimpleGrantedAuthority> authories = new ArrayList<>();
//                    stream(roles).forEach(role -> {
//                        authories.add(new SimpleGrantedAuthority(role));
//                    });
//
//                    UsernamePasswordAuthenticationToken authenticationToken
//                            = new UsernamePasswordAuthenticationToken(userName,null ,authories);
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(request, response);
//                } catch (JWTVerificationException | IOException | IllegalArgumentException | ServletException e) {
//
//                    response.setHeader("error", e.getMessage());
//                    response.setStatus(FORBIDDEN.value());
//                    Map<String, String> error = new HashMap<>();
//                    error.put("error_massage", e.getMessage());
//
//                    response.setContentType(APPLICATION_JSON_VALUE);
//                    new ObjectMapper().writeValue(response.getOutputStream(), error);
//                }
//            }
//            else {
//                filterChain.doFilter(request, response);
//            }
//        }
//
//    }
//
//}
