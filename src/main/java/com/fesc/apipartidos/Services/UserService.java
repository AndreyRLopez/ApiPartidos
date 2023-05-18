package com.fesc.apipartidos.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fesc.apipartidos.Data.Entidades.GameEntity;
import com.fesc.apipartidos.Data.Entidades.UserEntity;
import com.fesc.apipartidos.Data.Repositorios.IGameRepository;
import com.fesc.apipartidos.Data.Repositorios.IUserRepository;
import com.fesc.apipartidos.Errors.UserExistsException;
import com.fesc.apipartidos.Shared.GameDto;
import com.fesc.apipartidos.Shared.UserDto;


@Service
public class UserService implements IUserService{
    

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    IUserRepository iUserRepository;


    @Autowired
    IGameRepository iGameRepository;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDto createUser(UserDto userCreateDto) {
        
        if (iUserRepository.findByEmail(userCreateDto.getEmail()) != null) {
            throw new UserExistsException("El email ya ha sido registrado previamente");
        }

        if (iUserRepository.findByUsername(userCreateDto.getUsername()) != null) {
            throw new UserExistsException("El username ya ha sido registrado previamente");
        }

        UserEntity userEntityDto = modelMapper.map(userCreateDto, UserEntity.class);
        
        userEntityDto.setIdUser(UUID.randomUUID().toString());
        userEntityDto.setPasswordEncrypted(bCryptPasswordEncoder.encode(userCreateDto.getPassword()));

        UserEntity userEntity = iUserRepository.save(userEntityDto);

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        
        return userDto;
    }


    @Override
    public UserDto readUser(String username) {
        
        UserEntity userEntity = iUserRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        UserDto userDto = modelMapper.map(userEntity, UserDto.class);

        return userDto;
    }


    @Override
    public List<GameDto> readMyGames(String username) {
        
        UserEntity userEntity = iUserRepository.findByUsername(username);
        
        List<GameEntity> gameEntityList = iGameRepository.getByUserEntityIdOrderByCreatedDesc(userEntity.getId());

        List<GameDto> gameDtoList = new ArrayList<GameDto>();

        for (GameEntity gameEntity : gameEntityList) {
            
            GameDto gameDto = modelMapper.map(gameEntity, GameDto.class);

            gameDtoList.add(gameDto);
        }

        return gameDtoList;
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userEntity = iUserRepository.findByUsername(username);
     
        if(userEntity ==  null) {
            throw new UsernameNotFoundException(username);
        }

        User user = new User(userEntity.getUsername(), userEntity.getPasswordEncrypted(), new ArrayList<>());

        return user;
    }
}
