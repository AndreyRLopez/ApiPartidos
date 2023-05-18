package com.fesc.apipartidos.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fesc.apipartidos.Models.Peticiones.UserSingInRequestModel;
import com.fesc.apipartidos.Services.IUserService;
import com.fesc.apipartidos.Shared.UserDto;
import com.fesc.apipartidos.Utils.AppContext;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserAuthentication extends UsernamePasswordAuthenticationFilter{
    
    private final AuthenticationManager authenticationManager;


    public UserAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        
                try {
                    
                    UserSingInRequestModel userSigupRequestModel = new ObjectMapper().readValue(
                        request.getInputStream(), UserSingInRequestModel.class);

                    UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                        userSigupRequestModel.getUsername(), 
                        userSigupRequestModel.getPassword(),
                        new ArrayList<>());

                    Authentication authentication = authenticationManager.authenticate(upat);

                    return authentication;

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
        String username = ((User) authResult.getPrincipal()).getUsername();

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(ConstantsSecurity.TOKEN_SECRETO));

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + ConstantsSecurity.FECHA_EXPIRACION))
                .signWith(key)
                .compact();

        IUserService iUserService = (IUserService) AppContext.getBean("userService");
        UserDto userDto = iUserService.readUser(username);
        
        response.addHeader("Access-Control-Expose-Headers", "Authorization, idUser");
        response.addHeader("IdUser", userDto.getIdUser());
        response.addHeader(ConstantsSecurity.HEADER_STRING, ConstantsSecurity.TOKEN_PREFIJO + token);
    }
}