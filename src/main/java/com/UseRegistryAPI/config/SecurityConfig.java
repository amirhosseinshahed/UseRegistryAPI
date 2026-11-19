package com.UseRegistryAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

//        return http.csrf(csrf -> csrf.disable())
//                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
//                .authorizeHttpRequests(
//                        auth ->
//                                auth.requestMatchers("/auth/signup", "/health").permitAll()
//                                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults()).build();

        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/auth/signup", "/health").permitAll()
                        .anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        http.headers(headers ->
                headers.frameOptions(frame ->
                        frame.sameOrigin()
                )
        );

        return http.build();
    }


}
