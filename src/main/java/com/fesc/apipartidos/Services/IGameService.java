package com.fesc.apipartidos.Services;

import java.util.List;

import com.fesc.apipartidos.Shared.GameDto;


public interface IGameService {

    GameDto createGame(GameDto gameCreateDto);

    List<GameDto> gamesCreated();

    GameDto detailGame(String id);

    GameDto updateGame(String idGame, GameDto gameUpdateDto);
    
    void deleteGame(String idGame, long idUsuario);
}