package com.fesc.apipartidos.Shared;

import java.io.Serializable;
import java.util.Date;

public class GameDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private long id;
    private String idGame;

    private Date date;

    private long teamHome;
    private long teamAway;

    private String username;

    private String goalsHome;
    private String goalsAway;

    private Date created;

    private UserDto userEntity;
    private TeamDto teamEntityHome;
    private TeamDto teamEntityAway;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getIdGame() {
        return this.idGame;
    }
    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }


    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public long getTeamHome() {
        return this.teamHome;
    }
    public void setTeamHome(long teamHome) {
        this.teamHome = teamHome;
    }

    public long getTeamAway() {
        return this.teamAway;
    }
    public void setTeamAway(long teamAway) {
        this.teamAway = teamAway;
    }


    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getGoalsHome() {
        return this.goalsHome;
    }
    public void setGoalsHome(String goalsHome) {
        this.goalsHome = goalsHome;
    }

    public String getGoalsAway() {
        return this.goalsAway;
    }
    public void setGoalsAway(String goalsAway) {
        this.goalsAway = goalsAway;
    }


    public Date getCreated() {
        return this.created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }


    public UserDto getUserEntity() {
        return this.userEntity;
    }
    public void setUserEntity(UserDto userEntity) {
        this.userEntity = userEntity;
    }

    public TeamDto getTeamEntityHome() {
        return this.teamEntityHome;
    }
    public void setTeamEntityHome(TeamDto teamEntityHome) {
        this.teamEntityHome = teamEntityHome;
    }

    public TeamDto getTeamEntityAway() {
        return this.teamEntityAway;
    }
    public void setTeamEntityAway(TeamDto teamEntityVisitante) {
        this.teamEntityAway = teamEntityVisitante;
    }
}