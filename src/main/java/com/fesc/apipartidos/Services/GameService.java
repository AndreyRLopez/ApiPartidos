package com.fesc.apipartidos.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.apipartidos.Data.Entidades.TeamEntity;
import com.fesc.apipartidos.Data.Entidades.GameEntity;
import com.fesc.apipartidos.Data.Entidades.UserEntity;
import com.fesc.apipartidos.Data.Repositorios.ITeamRepository;
import com.fesc.apipartidos.Data.Repositorios.IGameRepository;
import com.fesc.apipartidos.Data.Repositorios.IUserRepository;
import com.fesc.apipartidos.Shared.GameDto;


@Service
public class GameService implements IGameService{
    

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    ITeamRepository iTeamRepository;


    @Autowired
    IUserRepository iUserRepository;


    @Autowired
    IGameRepository iGameRepository;


    @Override
    public GameDto createGame(GameDto gameCreateDto) {

        UserEntity userEntity = iUserRepository.findByUsername(gameCreateDto.getUsername());
        
        TeamEntity teamEntityHome = iTeamRepository.findById(gameCreateDto.getTeamHome());

        TeamEntity teamEntityAway = iTeamRepository.findById(gameCreateDto.getTeamAway());

        GameEntity gameEntity = new GameEntity();

        gameEntity.setIdGame(UUID.randomUUID().toString());
        gameEntity.setDate(gameCreateDto.getDate());
        gameEntity.setGoalsHome("0");
        gameEntity.setGoalsAway("0");
        gameEntity.setUserEntity(userEntity);
        gameEntity.setTeamEntityHome(teamEntityHome);
        gameEntity.setTeamEntityAway(teamEntityAway);

        GameEntity gameCreated = iGameRepository.save(gameEntity);

        GameDto gameDto = modelMapper.map(gameCreated, GameDto.class);

        return gameDto;
    }


    @Override
    public List<GameDto> gamesCreated() {
        
        List<GameEntity> gameEntityList = iGameRepository.gamesCreated();

        List<GameDto> gameDtoList = new ArrayList<>();

        for (GameEntity gameEntity : gameEntityList) {
            GameDto gameDto = modelMapper.map(gameEntity, GameDto.class);
            gameDtoList.add(gameDto);
        }

        return gameDtoList;
    }


    @Override
    public GameDto detailGame(String id) {
        
        GameEntity gameEntity = iGameRepository.findByIdGame(id);

        GameDto gameDto = modelMapper.map(gameEntity, GameDto.class);

        return gameDto;
    }


    @Override
    public GameDto updateGame(String idGame, GameDto gameUpdateDto) {
        
        GameEntity gameEntity = iGameRepository.findByIdGame(idGame);

        UserEntity userEntity = iUserRepository.findByUsername(gameUpdateDto.getUsername());

        if (gameEntity.getUserEntity().getId() != userEntity.getId()) {
            throw new RuntimeException("No se puede realizar esta accion");
        }

        gameEntity.setGoalsHome(gameUpdateDto.getGoalsHome());
        gameEntity.setGoalsAway(gameUpdateDto.getGoalsAway());

        GameEntity gameUpdatedEntity = iGameRepository.save(gameEntity);

        GameDto gameDto = modelMapper.map(gameUpdatedEntity, GameDto.class);

        return gameDto;
    }


    @Override
    public void deleteGame(String idGame, long idUser) {
        
        GameEntity gameEntity = iGameRepository.findByIdGame(idGame);

        if (gameEntity.getUserEntity().getId() != idUser) {
            throw new RuntimeException("No se puede eliminar el game");
        }

        iGameRepository.delete(gameEntity);
    }
}