package com.example.demenagemoi.model;

import com.example.demenagemoi.helpers.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Removal {

    private String date;

    private String address;

    private String arrivalAddress;

    private String description;

    private String idUser;

    public void setDate(String date) {
        try {
            SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.sss'Z'");
            Date currentDate = currentFormat.parse(date);

            SimpleDateFormat newFormat = new SimpleDateFormat("EEEE dd MMMM hh:mm", Locale.FRANCE);
            date = newFormat.format(currentDate);

            this.date = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDate() {
        return this.date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setArrivalAddress(String arrivalAddress) {
        this.arrivalAddress = arrivalAddress;
    }

    public String getArrivalAddress() {
        return this.arrivalAddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return this.idUser;
    }

    public static Removal fill(JSONObject jsonObject) throws JSONException {
        Removal entity = new Removal();
        if (jsonObject.has(Constants.Removal.DATE)) {
            entity.setDate(jsonObject.getString(Constants.Removal.DATE));
        }
        if (jsonObject.has(Constants.Removal.ADDRESS)) {
            entity.setAddress(jsonObject.getString(Constants.Removal.ADDRESS));
        }
        if (jsonObject.has(Constants.Removal.ARRIVAL_ADDRESS)) {
            entity.setArrivalAddress(jsonObject.getString(Constants.Removal.ARRIVAL_ADDRESS));
        }
        if (jsonObject.has(Constants.Removal.DESCRIPTION)) {
            entity.setDescription(jsonObject.getString(Constants.Removal.DESCRIPTION));
        }
        if (jsonObject.has(Constants.Removal.ID_USER)) {
            entity.setIdUser(jsonObject.getString(Constants.Removal.ID_USER));
        }
        return entity;
    }

    public static Collection<Removal> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return new ArrayList<>();
        List<Removal> olist = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
