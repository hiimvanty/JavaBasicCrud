package com.devcamp.api.task_56ddot20coutry_region.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot20coutry_region.models.Country;
import com.devcamp.api.task_56ddot20coutry_region.models.Region;
import com.devcamp.api.task_56ddot20coutry_region.services.CountryRegionService;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CountryRegionController {
    private CountryRegionService countryRegionService;

    public CountryRegionController(CountryRegionService countryRegionService) {
        this.countryRegionService = countryRegionService;
        initializeData();

    }

    private void initializeData() {
        List<Country> countries = new ArrayList<>();
        Region region1 = new Region("R1", "Region 1");
        Region region2 = new Region("R2", "Region 2");
        Region region3 = new Region("R3", "Region 3");

        Country country1 = new Country("C1", "Country 1");
        country1.getRegions().add(region1);
        country1.getRegions().add(region2);

        Country country2 = new Country("C2", "Country 2");
        country2.getRegions().add(region2);
        country2.getRegions().add(region3);

        Country country3 = new Country("C3", "Country 3");
        country3.getRegions().add(region1);
        country3.getRegions().add(region3);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        countryRegionService.setCountries(countries); // Set the initialized countries in the service
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryRegionService.getAllCountries();
    }

    @GetMapping("/countries/{countryCode}")
    public Country getCountryByCode(@PathVariable String countryCode) {
        return countryRegionService.getCountryByCode(countryCode); // Country not found
    }

    @GetMapping("/regions/{regionCode}")
    public Region getRegionByCode(@PathVariable String regionCode) {

        return countryRegionService.getRegionByCode(regionCode); // Region not found
    }
}
