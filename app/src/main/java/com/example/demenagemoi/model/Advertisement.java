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

public class Advertisement {

    private String availabilityDate;

    private String large;

    private String medium;

    private String small;

    private String description;

    private String idCompany;

    public void setAvailabilityDate(String availabilityDate) {
        try {
            SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.sss'Z'");
            Date currentDate = currentFormat.parse(availabilityDate);

            SimpleDateFormat newFormat = new SimpleDateFormat("EEEE dd MMMM hh:mm", Locale.FRANCE);
            availabilityDate = newFormat.format(currentDate);

            this.availabilityDate = availabilityDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getAvailabilityDate() {
        return this.availabilityDate;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getLarge() {
        return this.large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getIdCompany() {
        return this.idCompany;
    }

    public static Advertisement fill(JSONObject jsonObject) throws JSONException {
        Advertisement advertisement = new Advertisement();
        if (jsonObject.has(Constants.Advertisement.AVAILABILITY_DATE)) {
            advertisement.setAvailabilityDate(jsonObject.getString(Constants.Advertisement.AVAILABILITY_DATE));
        }
        if (jsonObject.has(Constants.Advertisement.SMALL)) {
            advertisement.setSmall(jsonObject.getString(Constants.Advertisement.SMALL));
        }
        if (jsonObject.has(Constants.Advertisement.MEDIUM)) {
            advertisement.setMedium(jsonObject.getString(Constants.Advertisement.MEDIUM));
        }
        if (jsonObject.has(Constants.Advertisement.LARGE)) {
            advertisement.setLarge(jsonObject.getString(Constants.Advertisement.LARGE));
        }
        if (jsonObject.has(Constants.Advertisement.DESCRIPTION)) {
            advertisement.setDescription(jsonObject.getString(Constants.Advertisement.DESCRIPTION));
        }
        if (jsonObject.has(Constants.Advertisement.ID_COMPANY)) {
            advertisement.setIdCompany(jsonObject.getString(Constants.Advertisement.ID_COMPANY));
        }
        return advertisement;
    }

    public static Collection<Advertisement> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return new ArrayList<>();
        List<Advertisement> olist = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
