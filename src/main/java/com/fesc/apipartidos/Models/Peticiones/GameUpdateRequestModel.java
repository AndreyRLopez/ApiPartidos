package com.fesc.apipartidos.Models.Peticiones;

public class GameUpdateRequestModel {
    
    private String goalsHome;
    private String goalsAway;

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
}