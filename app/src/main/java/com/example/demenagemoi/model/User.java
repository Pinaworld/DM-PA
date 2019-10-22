package com.example.demenagemoi.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.demenagemoi.helpers.Constants.User.CITY;
import static com.example.demenagemoi.helpers.Constants.User.EMAIL;
import static com.example.demenagemoi.helpers.Constants.User.FIRST_NAME;
import static com.example.demenagemoi.helpers.Constants.User.LAST_NAME;
import static com.example.demenagemoi.helpers.Constants.User.USER_PASS;
import static com.example.demenagemoi.helpers.Constants.User.ZIP_CODE;

public class User {

    private String firstName;

    private String lastName;

    private String zipCode;

    private String city;

    private String email;

    private String password;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public static User fill(JSONObject jsonObject) throws JSONException {
        User entity = new User();
        if (jsonObject.has(FIRST_NAME)) {
            entity.setFirstName(jsonObject.getString(FIRST_NAME));
        }
        if (jsonObject.has(LAST_NAME)) {
            entity.setLastName(jsonObject.getString(LAST_NAME));
        }
        if (jsonObject.has(ZIP_CODE)) {
            entity.setZipCode(jsonObject.getString(ZIP_CODE));
        }
        if (jsonObject.has(CITY)) {
            entity.setCity(jsonObject.getString(CITY));
        }
        if (jsonObject.has(EMAIL)) {
            entity.setEmail(jsonObject.getString(EMAIL));
        }
        if (jsonObject.has(USER_PASS)) {
            entity.setPassword(jsonObject.getString(USER_PASS));
        }
        return entity;
    }

    public static List<User> fillList(JSONArray jsonArray) throws JSONException {
        if (jsonArray == null || jsonArray.length() == 0)
            return new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            userList.add(fill(jsonArray.getJSONObject(i)));
        }
        return userList;
    }
}
