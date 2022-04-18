/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author mntemnte
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
 
    private final  AuthenticationManager authenticationManager;
    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager =authenticationManager;
    }

   
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
     String username = request.getParameter("userName");
     String password = request.getParameter("password");
//        try {
//            User creds = new ObjectMapper()
//                    .readValue(request.getInputStream(), User.class);
//               return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            creds.getUsername(),
//                            creds.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException ex) {
//           
//        throw new RuntimeException(ex);
//        }
      
return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
 User  user = (User)auth.getPrincipal();
        Algorithm algo = Algorithm.HMAC256("secret".getBytes());
         String access_token = JWT.create()
                 .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 50*60*1000))
                 .withIssuer(request.getRequestURL().toString())
                 .withClaim("roles",
                  user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                  
                 .sign(algo);
         
         String refresh_token = JWT.create()
                 .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 60*60*1000))
                 .withIssuer(request.getRequestURL().toString())
                 .sign(algo);
         
        response.setHeader("access_token", access_token);
        response.setHeader("refresh_token", refresh_token);
        Map<String,String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                 
    
    }
    
    
    
    
}
