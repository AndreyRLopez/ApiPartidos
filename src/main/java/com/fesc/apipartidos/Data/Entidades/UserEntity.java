package com.fesc.apipartidos.Data.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "user")
@Table(indexes = {
    @Index(columnList = "idUser", name = "index_idUser", unique = true),
    @Index(columnList = "email", name = "index_email", unique = true),
    @Index(columnList = "username", name = "index_username", unique = true)
})


public class UserEntity implements Serializable{
    

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false)
    private String idUser;


    @Column(nullable = false, length = 100)
    private String name;


    @Column(nullable = false, length = 50)
    private String email;


    @Column(nullable = false, length = 12)
    private String username;


    @Column(nullable = false)
    private String passwordEncrypted;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<GameEntity> gameEntityList = new ArrayList<>();


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

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordEncrypted() {
        return this.passwordEncrypted;
    }
    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public List<GameEntity> getGameEntityList() {
        return this.gameEntityList;
    }
    public void setGameEntityList(List<GameEntity> gameEntityList) {
        this.gameEntityList = gameEntityList;
    }
}