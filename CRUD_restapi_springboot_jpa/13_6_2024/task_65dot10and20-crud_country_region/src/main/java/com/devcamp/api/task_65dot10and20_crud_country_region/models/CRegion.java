package com.devcamp.api.task_65dot10and20_crud_country_region.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "region")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_code", unique = true)
    private String regionCode;
    @Column(name = "region_name")
    private String regionName;

    @ManyToOne
    @JsonIgnore
    private CCountry country;

    @Transient
    private String countryName;

    @JsonIgnore
    public String getCountryName() {
        return getCountry().getCountryName();
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public CRegion() {
        super();
    }

    public CRegion(Long id, String regionCode, String regionName) {
        this.id = id;
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @JsonIgnore
    public CCountry getCountry() {
        return country;
    }

    public void setCountry(CCountry country) {
        this.country = country;
    };

}
