package com.fitzone.FITZONE.Models.User;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String username;
    private String password;
    private Access access;

    public User(String username, String password, Access access) {
        this.username = username;
        this.password = password;
        this.access = access;
    }
}
