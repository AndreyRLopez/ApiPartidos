package com.fesc.apipartidos.Data.Repositorios;

import org.springframework.data.repository.CrudRepository;

import com.fesc.apipartidos.Data.Entidades.TeamEntity;


public interface ITeamRepository extends CrudRepository<TeamEntity, Long>{
    
    TeamEntity findById(long id);
}