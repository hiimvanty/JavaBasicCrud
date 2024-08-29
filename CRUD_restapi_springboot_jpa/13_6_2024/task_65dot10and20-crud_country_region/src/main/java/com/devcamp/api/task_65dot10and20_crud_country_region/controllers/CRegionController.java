package com.devcamp.api.task_65dot10and20_crud_country_region.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_65dot10and20_crud_country_region.models.CCountry;
import com.devcamp.api.task_65dot10and20_crud_country_region.models.CRegion;
import com.devcamp.api.task_65dot10and20_crud_country_region.repositories.ICCountryRepository;
import com.devcamp.api.task_65dot10and20_crud_country_region.repositories.ICRegionRepository;
import com.devcamp.api.task_65dot10and20_crud_country_region.services.CCountryService;
import com.devcamp.api.task_65dot10and20_crud_country_region.services.CRegionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CRegionController {
    @Autowired
    CRegionService pRegionService;

    @Autowired
    ICRegionRepository pRegionRepository;

    @Autowired
    CCountryService pCountryService;

    @GetMapping("/region/all")
    public ResponseEntity<List<CRegion>> getAllRegion() {
        try {
            return new ResponseEntity<List<CRegion>>(pRegionService.getAllRegion(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/country/{countryId}/regions")
    public ResponseEntity<List<CRegion>> getRegionByCountryId(@PathVariable(value = "countryId") Long countryId) {
        try {
            return new ResponseEntity<List<CRegion>>(pRegionService.getRegionByCountryId(countryId), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/region/detail/{id}")
    public ResponseEntity<CRegion> getRegionByRegionId(@PathVariable("id") Long id) {
        try {
            Optional<CRegion> otpRegion = pRegionService.getRegionByRegionId(id);
            if (otpRegion.isPresent()) {
                return new ResponseEntity<CRegion>(otpRegion.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/region/create/{id}")
    public ResponseEntity<Object> createRegion(@PathVariable("id") Long id, @RequestBody CRegion region) {
        try {
            Optional<CCountry> countryData = pCountryService.getCountryById(id);
            if (countryData.isPresent()) {
                CRegion newRegion = new CRegion();
                newRegion.setRegionName(region.getRegionName());
                newRegion.setRegionCode(region.getRegionCode());
                newRegion.setCountry(region.getCountry());

                CCountry _country = countryData.get();
                newRegion.setCountry(_country);
                newRegion.setCountryName(_country.getCountryName());

                CRegion savedRegion = pRegionService.createRegion(newRegion);
                return new ResponseEntity<>(savedRegion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/region/update/{id}")
    public ResponseEntity<CRegion> updateRegion(@PathVariable("id") Long id, @RequestBody CRegion region) {
        try {
            Optional<CRegion> regionData = pRegionService.getRegionByRegionId(id);
            if (regionData.isPresent()) {
                CRegion newRegion = regionData.get();
                newRegion.setRegionName(region.getRegionName());
                newRegion.setRegionCode(region.getRegionCode());

                CRegion saveRegion = pRegionService.updateRegion(newRegion);
                return new ResponseEntity<CRegion>(saveRegion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/region/delete/{id}")
    public ResponseEntity<String> deleteRegionById(@PathVariable("id") Long id) {
        try {
            pRegionService.deleteRegionById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
