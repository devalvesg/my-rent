package com.devalvesg.my_rent.Infrastructure.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/public/**").permitAll() // Allow public access
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict to ADMIN role
                        .anyRequest().authenticated() // Require authentication for other requests
                )
                .httpBasic(); // Also allow HTTP Basic authentication for simplicity
        return http.build();
    }
}