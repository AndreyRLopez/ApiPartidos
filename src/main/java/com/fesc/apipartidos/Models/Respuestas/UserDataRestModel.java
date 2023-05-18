package com.fesc.apipartidos.Models.Respuestas;

import java.util.ArrayList;
import java.util.List;

public class UserDataRestModel {
    
    private String idUser;

    private String name;
    private String username;

    private String email;
    
    private List<GameDataRestModel> gameDataRestModelList = new ArrayList<>();


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


    public List<GameDataRestModel> getGameDataRestModelList() {
        return this.gameDataRestModelList;
    }
    public void setGameDataRestModelList(List<GameDataRestModel> gameDataRestModelList) {
        this.gameDataRestModelList = gameDataRestModelList;
    }
}