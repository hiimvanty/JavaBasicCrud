package com.devcamp.api.task_65dot10and20_crud_country_region.models;

import java.util.*;
import jakarta.persistence.*;;

@Entity
@Table(name = "country")
public class CCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", unique = true)
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(targetEntity = CRegion.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<CRegion> regions;

    public CCountry() {
        super();
    }

    public CCountry(Long id, String countryCode, String countryName) {
        this.id = id;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CRegion> getRegions() {
        return regions;
    }

    public void setRegions(List<CRegion> regions) {
        this.regions = regions;
    };

}
