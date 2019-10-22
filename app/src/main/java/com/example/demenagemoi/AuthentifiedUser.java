package com.example.demenagemoi;

import com.auth0.android.jwt.JWT;
import com.example.demenagemoi.model.User;

public class AuthentifiedUser {

    private User user;
    private JWT token;
    private static final AuthentifiedUser ourInstance = new AuthentifiedUser();

    public static AuthentifiedUser getInstance() {
        return ourInstance;
    }

    private AuthentifiedUser() {
    }

    public void setToken(JWT token) {
        this.token = token;
    }

    public JWT getToken() {
        return token;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}