package com.fesc.apipartidos.Security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.fesc.apipartidos.Services.IUserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    private final IUserService iUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    
    public SecurityConfiguration(IUserService iUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.iUserService = iUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        return http
            .cors()
            .and()
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/user").permitAll()
            .requestMatchers(HttpMethod.GET, "/game").permitAll()
            .requestMatchers(HttpMethod.GET, "/game/{id}").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(getFiltroAutenticacion(authenticationManager))
            .addFilter(new TokenAuthorization(authenticationManager))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .build();
        
    }


    public UserAuthentication getFiltroAutenticacion(AuthenticationManager authenticationManager) throws Exception {
        
        final UserAuthentication userAutenticacion = new UserAuthentication(authenticationManager);

        userAutenticacion.setFilterProcessesUrl("/user/login");

        return userAutenticacion;

    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        return configurationSource;
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        // authenticationManager.userDetailsService(iUserService).passwordEncoder(bCryptPasswordEncoder);
        // return authenticationManager;

        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(iUserService)
            .passwordEncoder(bCryptPasswordEncoder)
            .and()
            .build();
    }
}