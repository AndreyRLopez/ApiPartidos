package com.fesc.apipartidos.Shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable{
   
    private static final long serialVersionUID = 1L;

    private long id;
    private String idUser;

    private String name;
    private String username;

    private String email;
    private String password;
    private String passwordEncrypt;
    
    private List<GameDto> gameDtoList = new ArrayList<>();

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getIdUser() {
        return this.idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordEncrypt() {
        return this.passwordEncrypt;
    }
    public void setPasswordEncrypt(String passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }


    public List<GameDto> getGameDtoList() {
        return this.gameDtoList;
    }
    public void setGameDtoList(List<GameDto> gameDtoList) {
        this.gameDtoList = gameDtoList;
    }
}