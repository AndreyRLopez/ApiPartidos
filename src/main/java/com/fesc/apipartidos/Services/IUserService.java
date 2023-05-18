package com.fesc.apipartidos.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fesc.apipartidos.Shared.GameDto;
import com.fesc.apipartidos.Shared.UserDto;


public interface IUserService extends UserDetailsService{
    
    UserDto createUser(UserDto userCreateDto);
    
    UserDto readUser(String username);

    List<GameDto> readMyGames(String username);
}