package com.fesc.apipartidos.Data.Repositorios;

import org.springframework.data.repository.CrudRepository;
import com.fesc.apipartidos.Data.Entidades.UserEntity;


public interface IUserRepository extends CrudRepository<UserEntity, Long>{
    
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}