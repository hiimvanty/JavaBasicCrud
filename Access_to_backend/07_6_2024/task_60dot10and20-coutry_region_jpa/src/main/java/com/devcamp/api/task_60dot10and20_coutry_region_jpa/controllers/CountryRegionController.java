package com.devcamp.api.task_60dot10and20_coutry_region_jpa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_60dot10and20_coutry_region_jpa.models.CCountry;
import com.devcamp.api.task_60dot10and20_coutry_region_jpa.models.CRegion;
import com.devcamp.api.task_60dot10and20_coutry_region_jpa.reposity.ICountryRepository;
import com.devcamp.api.task_60dot10and20_coutry_region_jpa.reposity.IRegionRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CountryRegionController {
    @Autowired
    ICountryRepository pCountryRepository;

    @Autowired
    IRegionRepository pRegionRepository;

    @GetMapping("/countries")
    public ResponseEntity<List<CCountry>> getAllCountries() {
        try {
            List<CCountry> countriesList = new ArrayList<CCountry>();
            pCountryRepository.findAll().forEach(countriesList::add);
            if (countriesList.size() == 0) {
                return new ResponseEntity<>(countriesList, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(countriesList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/regions")
    public ResponseEntity<Set<CRegion>> getRegionsByCountryCode(
            @RequestParam(value = "countryCode") String countryCode) {
        try {
            CCountry vCountry = pCountryRepository.findByCountryCode(countryCode);

            if (vCountry != null) {
                return new ResponseEntity<>(vCountry.getRegions(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
