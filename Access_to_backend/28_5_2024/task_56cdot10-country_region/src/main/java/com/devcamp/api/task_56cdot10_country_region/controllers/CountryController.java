package com.devcamp.api.task_56cdot10_country_region.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot10_country_region.models.Country;
import com.devcamp.api.task_56cdot10_country_region.services.CountryService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public  ArrayList<Country> getCountries(){
        return countryService.getCountries();
    }

    @GetMapping("/country-info")
    public Country getCountry(@RequestParam String countryCode){
        return countryService.getCountryByCountryCode(countryCode);
    }
    
}

