package com.devcamp.api.task_60dot10and20_coutry_region_jpa.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class CCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long country_id;

    @Column(name = "country_code", unique = true)
    private String countryCode;
    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CRegion> regions;

    public CCountry() {

    }

    public CCountry(String countryCode, String countryName) {
        // this.country_id = country_id;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
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

    public Set<CRegion> getRegions() {
        return regions;
    }

    public void setRegions(Set<CRegion> regions) {
        this.regions = regions;
    };

}
