package com.example.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   // allow all requests
            )
            .csrf(csrf -> csrf.disable())   // disable CSRF for simplicity
            .formLogin(form -> form.disable()) // disable default login form
            .httpBasic(basic -> basic.disable()); // disable basic auth
        return http.build();
    }
}
