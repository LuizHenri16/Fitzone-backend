package com.fitzone.FITZONE.Models.User;

import jakarta.persistence.*;
import com.fitzone.FITZONE.Types.Access;

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
