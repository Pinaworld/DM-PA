package com.example.demenagemoi;

public class AuthentifiedUserID {

    String id;
    private static final AuthentifiedUserID ourInstance = new AuthentifiedUserID();

    public static AuthentifiedUserID getInstance() {
        return ourInstance;
    }

    private AuthentifiedUserID() {
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }
}