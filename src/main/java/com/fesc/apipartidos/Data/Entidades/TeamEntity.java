package com.fesc.apipartidos.Data.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "team")
public class TeamEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 20)
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamEntityHome")
    private List<GameEntity> gameEntityHomeList = new ArrayList<>();
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamEntityAway")
    private List<GameEntity> gameEntityAwayList = new ArrayList<>();


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

    public List<GameEntity> getGameEntityHomeList() {
        return this.gameEntityHomeList;
    }
    public void setGameEntityHomeList(List<GameEntity> gameEntityHomeList) {
        this.gameEntityHomeList = gameEntityHomeList;
    }

    public List<GameEntity> getGameEntityAwayList() {
        return this.gameEntityAwayList;
    }
    public void setGameEntityAwayList(List<GameEntity> gameEntityAwayList) {
        this.gameEntityAwayList = gameEntityAwayList;
    }
}