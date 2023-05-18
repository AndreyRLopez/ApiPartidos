package com.fesc.apipartidos.Data.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fesc.apipartidos.Data.Entidades.GameEntity;


public interface IGameRepository extends PagingAndSortingRepository<GameEntity, Long>{
    
    GameEntity save(GameEntity gameEntity);

    void delete(GameEntity gameEntity);
    
    List<GameEntity> getByUserEntityIdOrderByCreatedDesc(Long userEntityId);

    
    @Query(nativeQuery = true, value = "SELECT * FROM game ORDER BY created DESC LIMIT 10")
    List<GameEntity> gamesCreated();

    GameEntity findByIdGame(String id);
}