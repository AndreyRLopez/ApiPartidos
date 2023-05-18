package com.fesc.apipartidos.Models.Peticiones;

import java.util.Date;

public class GameCreateRequestModel {
    
    private Date date;

    private String teamHome;
    private String teamAway;


    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public String getTeamHome() {
        return this.teamHome;
    }
    public void setTeamHome(String teamHome) {
        this.teamHome = teamHome;
    }

    public String getTeamAway() {
        return this.teamAway;
    }
    public void setTeamAway(String teamAway) {
        this.teamAway = teamAway;
    } 
}