package com.example.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.persistence.type.PermissionType.*;
import static com.example.persistence.type.RoleType.PERSONAL;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthorizationSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/open/**", "/api/auth/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/api/personal/**").hasAnyRole(PERSONAL.name())
                        .requestMatchers(GET, "/api/personal/**").hasAuthority(PERSONAL_READ.name())
                        .requestMatchers(POST, "/api/personal/**").hasAuthority(PERSONAL_CREATE.name())
                        .requestMatchers(PUT, "/api/personal/**").hasAuthority(PERSONAL_UPDATE.name())
                        .requestMatchers(DELETE, "/api/personal/**").hasAuthority(PERSONAL_DELETE.name())
                        .requestMatchers(GET, "/api/admin/**").hasAuthority(ADMIN_READ.name())
                        .requestMatchers(POST, "/api/admin/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT, "/api/admin/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE, "/api/admin/**").hasAuthority(ADMIN_DELETE.name())
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
