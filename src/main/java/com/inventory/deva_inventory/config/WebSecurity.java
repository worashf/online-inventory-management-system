/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.deva_inventory.config;

import com.inventory.deva_inventory.filter.CustomAuthenticationFilter;
//import com.inventory.deva_inventory.filter.CustomAuthorizationFilter;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author mntemnte
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailService")
    private UserDetailsService onUserDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(onUserDetailsService).passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthentication = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthentication.setFilterProcessesUrl("/api/login");
        http.cors()
                .configurationSource(corsConfigurationSource()).and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            http.authorizeRequests().antMatchers("/api/login/**","/api/roles/***").permitAll();
//            http.authorizeRequests().antMatchers(GET,"/api/courses/**").permitAll();
//            http.authorizeRequests().antMatchers("/api/checktoken/**").permitAll();
//             http.authorizeRequests().antMatchers(GET,"/api/categories/**").permitAll();
//            http.authorizeRequests().antMatchers(GET,"/api/users/**").hasAnyAuthority("Admin");
//            http.authorizeRequests().antMatchers(GET,"/api/requests/**").hasAnyAuthority("Admin");
//       http.authorizeRequests().antMatchers(GET,"/api/your/courses/**").hasAnyAuthority("Teacher");
//       http.authorizeRequests().antMatchers(GET,"/api/course/requests/**").hasAnyAuthority("Admin");

//     http.authorizeRequests().antMatchers(POST,"/api/requests/approve/**").hasAnyAuthority("Admin");
//               http.authorizeRequests().antMatchers(POST,"/api/users/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(customAuthentication);
//           http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOriginPattern("*");
//      configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
