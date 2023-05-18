package com.fesc.apipartidos.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apipartidos.Models.Peticiones.UserCreateRequestModel;
import com.fesc.apipartidos.Models.Respuestas.GameDataRestModel;
import com.fesc.apipartidos.Models.Respuestas.UserDataRestModel;
import com.fesc.apipartidos.Services.IUserService;
import com.fesc.apipartidos.Shared.GameDto;
import com.fesc.apipartidos.Shared.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    IUserService iUserService;


    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserDataRestModel readUser() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UserDto userDto = iUserService.readUser(username);

        UserDataRestModel userDataRestModel = modelMapper.map(userDto, UserDataRestModel.class);

        return userDataRestModel;
    }


    @GetMapping(path = "/mygames")
    public List<GameDataRestModel> readMyGames() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<GameDto> gameDtoList = iUserService.readMyGames(username);

        List<GameDataRestModel> gameDataRestModelList = new ArrayList<>();

        for (GameDto gameDto : gameDtoList) {
            
            GameDataRestModel gameDataRestModel = modelMapper.map(gameDto, GameDataRestModel.class);

            if (gameDataRestModel.getDate().compareTo(new Date(System.currentTimeMillis())) < 0) {
                gameDataRestModel.setPlayed(true);
            }

            gameDataRestModelList.add(gameDataRestModel);
        }

        return gameDataRestModelList;
    }

    
    @PostMapping
    public UserDataRestModel createUser(@RequestBody UserCreateRequestModel userCreateRequestModel) {
        
        UserDto userCreateDto = modelMapper.map(userCreateRequestModel, UserDto.class);
        UserDto userDto = iUserService.createUser(userCreateDto);

        UserDataRestModel userDataRestModel = modelMapper.map(userDto, UserDataRestModel.class);
        
        return userDataRestModel;
    }
}