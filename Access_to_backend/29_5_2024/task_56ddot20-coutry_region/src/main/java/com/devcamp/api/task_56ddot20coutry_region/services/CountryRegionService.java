package com.devcamp.api.task_56ddot20coutry_region.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56ddot20coutry_region.models.Country;
import com.devcamp.api.task_56ddot20coutry_region.models.Region;

@Service
public class CountryRegionService {
    private List<Country> countries;

    public CountryRegionService() {
        countries = new ArrayList<>();
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountryByIndex(int index) {
        if (index >= 0 && index < countries.size()) {
            return countries.get(index);
        }
        return null;
    }

    public Country getCountryByCode(String code) {
        for (Country country : countries) {
            if (country.getCountryCode().equals(code)) {
                return country;
            }
        }
        return null;
    }

    public Region getRegionByCode(String regionCode) {
        for (Country country : countries) {
            for (Region region : country.getRegions()) {
                if (region.getRegionCode().equals(regionCode)) {
                    return region;
                }
            }
        }
        return null;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
