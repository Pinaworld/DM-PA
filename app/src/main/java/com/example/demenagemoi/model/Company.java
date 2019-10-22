package com.example.demenagemoi.model;

import com.example.demenagemoi.helpers.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Company {

    private String idCompany;

    private String name;

    private String SIREN;

    private String city;

    private String street;

    private String number;

    private String zipCode;

    private String email;

    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return this.name;
    }

    public void setSIREN(String SIREN) {
        this.SIREN = SIREN;
    }

    public String getSIREN() {
        return this.SIREN;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Company fill(JSONObject jsonObject) throws JSONException {
        Company company = new Company();
        if (jsonObject.has(Constants.Company.ID)) {
            company.setIdCompany(jsonObject.getString(Constants.Company.ID));
        }
        if (jsonObject.has(Constants.Company.NAME)) {
            company.setName(jsonObject.getString(Constants.Company.NAME));
        }
        if (jsonObject.has(Constants.Company.SIREN)) {
            company.setSIREN(jsonObject.getString(Constants.Company.SIREN));
        }
        if (jsonObject.has(Constants.Company.CITY)) {
            company.setCity(jsonObject.getString(Constants.Company.CITY));
        }
        if (jsonObject.has(Constants.Company.NUMBER)) {
            company.setNumber(jsonObject.getString(Constants.Company.NUMBER));
        }
        if (jsonObject.has(Constants.Company.ZIPCODE)) {
            company.setZipCode(jsonObject.getString(Constants.Company.ZIPCODE));
        }
        if (jsonObject.has(Constants.Company.EMAIL)) {
            company.setEmail(jsonObject.getString(Constants.Company.EMAIL));
        }
        if (jsonObject.has(Constants.Company.COMPANY_PASS)) {
            company.setPassword(jsonObject.getString(Constants.Company.COMPANY_PASS));
        }
        return company;
    }

    public static Collection<Company> fillList(JSONArray jsonarray) throws JSONException {
        if (jsonarray == null || jsonarray.length() == 0)
            return new ArrayList<>();
        List<Company> olist = new ArrayList<>();
        for (int i = 0; i < jsonarray.length(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }

}
