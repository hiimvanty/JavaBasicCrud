package com.devcamp.api.task_56cdot10_country_region.models;

import java.util.ArrayList;

public class Country {

    private String countryCode;
    private String countryName;
    private ArrayList<Region> regions;

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Country(String countryCode, String countryName, ArrayList<Region> regions) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regions = regions;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

}
