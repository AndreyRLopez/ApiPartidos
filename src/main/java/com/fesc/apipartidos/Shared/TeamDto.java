package com.fesc.apipartidos.Shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TeamDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private long id;

    private String name;

    private List<GameDto> gameDtoHomeList = new ArrayList<>();
    private List<GameDto> gameDtoAwayList = new ArrayList<>();


    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public List<GameDto> getGameDtoHomeList() {
        return this.gameDtoHomeList;
    }
    public void setGameDtoHomeList(List<GameDto> gameDtoHomeList) {
        this.gameDtoHomeList = gameDtoHomeList;
    }

    public List<GameDto> getGameDtoAwayList() {
        return this.gameDtoAwayList;
    }
    public void setGameDtoAwayList(List<GameDto> gameDtoAwayList) {
        this.gameDtoAwayList = gameDtoAwayList;
    }    
}