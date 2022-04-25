package com.login.auth.Model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "passwd")
    private String password;

    @Column(name = "rol")
    private String rol;

    public User() {
    }

    public User(int idUser, String username, String password, String rol) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return idUser;
    }

    public void setId(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
