package com.fesc.apipartidos.Models.Respuestas;

import java.util.Date;

public class GameDataRestModel {
    
    private String idGame;
    
    private Date date;
    
    private String goalsHome;
    private String goalsAway;

    private Date created;
    private boolean played;

    private UserDataRestModel userEntity;
    
    private TeamDataRestModel teamEntityHome;
    private TeamDataRestModel teamEntityAway;


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

    public boolean isPlayed() {
        return this.played;
    }
    public boolean getPlayed() {
        return this.played;
    }
    public void setPlayed(boolean played) {
        this.played = played;
    }


    public UserDataRestModel getUserEntity() {
        return this.userEntity;
    }
    public void setUserEntity(UserDataRestModel userEntity) {
        this.userEntity = userEntity;
    }

    public TeamDataRestModel getTeamEntityHome() {
        return this.teamEntityHome;
    }
    public void setTeamEntityHome(TeamDataRestModel teamEntityHome) {
        this.teamEntityHome = teamEntityHome;
    }

    public TeamDataRestModel getTeamEntityAway() {
        return this.teamEntityAway;
    }
    public void setTeamEntityAway(TeamDataRestModel teamEntityAway) {
        this.teamEntityAway = teamEntityAway;
    }
}