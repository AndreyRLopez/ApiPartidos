package com.fesc.apipartidos.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.apipartidos.Models.Peticiones.GameUpdateRequestModel;
import com.fesc.apipartidos.Models.Peticiones.GameCreateRequestModel;
import com.fesc.apipartidos.Models.Respuestas.MessageRestModel;
import com.fesc.apipartidos.Models.Respuestas.GameDataRestModel;
import com.fesc.apipartidos.Services.IGameService;
import com.fesc.apipartidos.Services.IUserService;
import com.fesc.apipartidos.Shared.GameDto;
import com.fesc.apipartidos.Shared.UserDto;

@RestController
@RequestMapping("/game")
public class GameController {
    

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    IGameService iGameService;


    @Autowired
    IUserService iUserService;


    @GetMapping
    public List<GameDataRestModel> readGames() {

        List<GameDto> gameDtoList = iGameService.gamesCreated();

        List<GameDataRestModel> gameDataRestModelList = new ArrayList<>();

        for (GameDto gameDto : gameDtoList) {
            GameDataRestModel gameDataRestModel = modelMapper.map(gameDto, GameDataRestModel.class);
            gameDataRestModelList.add(gameDataRestModel);
        }

        return gameDataRestModelList;
    }


    @GetMapping(path = "/{id}")
    public GameDataRestModel detailGame(@PathVariable String id) {
        
        GameDto gameDto = iGameService.detailGame(id);

        GameDataRestModel gameDataRestModel = modelMapper.map(gameDto, GameDataRestModel.class);

        return gameDataRestModel;
    }


    @PostMapping
    public GameDataRestModel createGame(@RequestBody GameCreateRequestModel gameCreateRequestModel) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        GameDto gameCreateDto = modelMapper.map(gameCreateRequestModel, GameDto.class);
        gameCreateDto.setUsername(username);

        GameDto gameDto = iGameService.createGame(gameCreateDto);

        GameDataRestModel gameDataRestModel = modelMapper.map(gameDto, GameDataRestModel.class);

        return gameDataRestModel;
    }


    @PutMapping(path = "/{id}")
    public GameDataRestModel updateGame(@PathVariable String id, @RequestBody GameUpdateRequestModel gameUpdateRequestModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();
        
        GameDto gameUpdateDto = modelMapper.map(gameUpdateRequestModel, GameDto.class);
        gameUpdateDto.setUsername(username);

        GameDto gameDto = iGameService.updateGame(id, gameUpdateDto);

        GameDataRestModel gameDataRestModel = modelMapper.map(gameDto, GameDataRestModel.class);

        return gameDataRestModel;
    }

    
    @DeleteMapping(path = "/{id}")
    public MessageRestModel deleteGame(@PathVariable String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UserDto userDto = iUserService.readUser(username);

        MessageRestModel messageRestModel = new MessageRestModel();
        messageRestModel.setName("Eliminar");

        iGameService.deleteGame(id, userDto.getId());

        messageRestModel.setResult("Partido eliminado con exito");

        return messageRestModel;
    }
}