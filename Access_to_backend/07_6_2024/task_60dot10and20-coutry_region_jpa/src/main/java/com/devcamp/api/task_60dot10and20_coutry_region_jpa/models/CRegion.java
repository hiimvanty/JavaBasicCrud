package com.devcamp.api.task_60dot10and20_coutry_region_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long region_id;
    @Column(name = "region_code", unique = true)
    private String regionCode;
    @Column(name = "region_name")
    private String regionName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "country_id")
    private CCountry country;

    public CRegion() {

    }

    public CRegion( String regionCode, String regionName) {
        // this.region_id = region_id;
        this.regionCode = regionCode;
        this.regionName = regionName;
        // this.country = country;
    }

    public long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(long region_id) {
        this.region_id = region_id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public CCountry getCountry() {
        return country;
    }

    public void setCountry(CCountry country) {
        this.country = country;
    };

}
