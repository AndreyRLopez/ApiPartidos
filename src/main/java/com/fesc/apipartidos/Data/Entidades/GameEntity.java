package com.fesc.apipartidos.Data.Entidades;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "game")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {

    @Index(columnList = "idGame", name = "index_idGame", unique = true)
})


public class GameEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false)
    private String idGame;
    

    @Column(nullable = false)
    private Date date;
    

    @Column(nullable = false)
    private String goalsHome;
    

    @Column(nullable = false)
    private String goalsAway;
    

    @CreatedDate
    private Date created;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;


    @ManyToOne
    @JoinColumn(name = "id_teamHome")
    private TeamEntity teamEntityHome;


    @ManyToOne
    @JoinColumn(name = "id_teamAway")
    private TeamEntity teamEntityAway;


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

    public Date getCreado() {
        return this.created;
    }
    public void setCreado(Date created) {
        this.created = created;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TeamEntity getTeamEntityHome() {
        return this.teamEntityHome;
    }
    public void setTeamEntityHome(TeamEntity teamEntityHome) {
        this.teamEntityHome = teamEntityHome;
    }

    public TeamEntity getTeamEntityAway() {
        return this.teamEntityAway;
    }
    public void setTeamEntityAway(TeamEntity teamEntityAway) {
        this.teamEntityAway = teamEntityAway;
    }
}