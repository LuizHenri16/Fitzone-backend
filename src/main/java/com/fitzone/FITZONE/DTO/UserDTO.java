package com.fitzone.FITZONE.DTO;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String access;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String access) {
        this.id = id;
        this.username = username;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }
}


