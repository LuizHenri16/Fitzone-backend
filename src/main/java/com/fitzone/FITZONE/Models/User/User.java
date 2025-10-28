package com.fitzone.FITZONE.Models.User;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String username;
    private String password;
    private String access;

    public User(String username, String password, String access) {
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public User(long id, String username, String password, String access) {
        this.Id = id;
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public User() {
    }

    public long getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        Id = id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new  SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
