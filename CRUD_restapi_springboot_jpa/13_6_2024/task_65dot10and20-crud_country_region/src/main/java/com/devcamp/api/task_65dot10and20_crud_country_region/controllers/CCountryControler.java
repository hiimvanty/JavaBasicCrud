package com.devcamp.api.task_65dot10and20_crud_country_region.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.devcamp.api.task_65dot10and20_crud_country_region.repositories.ICCountryRepository;
import com.devcamp.api.task_65dot10and20_crud_country_region.services.CCountryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CCountryControler {
    @Autowired
    private CCountryService pCCountryService;

    @Autowired
    private ICCountryRepository pCountryRepository;

    @GetMapping("/country/all")
    public ResponseEntity<List<CCountry>> getAllCountries() {
        try {
            return new ResponseEntity<List<CCountry>>(pCCountryService.getCountryList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/country/detail/{id}")
    public ResponseEntity<CCountry> getCountryById(@PathVariable("id") Long id) {
        try {
            Optional<CCountry> optCountry = pCCountryService.getCountryById(id);
            if (optCountry.isPresent()) {
                return new ResponseEntity<CCountry>(optCountry.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/country/create")
    public ResponseEntity<CCountry> createCountry(@RequestBody CCountry cCountry) {
        try {
            CCountry newRole = new CCountry();
            newRole.setCountryCode(cCountry.getCountryCode());
            newRole.setCountryName(cCountry.getCountryName());
            newRole.setRegions(cCountry.getRegions());

            CCountry saveRole = pCCountryService.createCountry(newRole);

            return new ResponseEntity<CCountry>(saveRole, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/country/create2")
    public ResponseEntity<Object> createCountry2(@RequestBody CCountry cCountry) {
        try {
            CCountry newRole = new CCountry();
            newRole.setCountryName(cCountry.getCountryName());
            newRole.setCountryCode(cCountry.getCountryCode());
            newRole.setRegions(cCountry.getRegions());
            CCountry savedRole = pCountryRepository.save(newRole);
            return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("+++++++++++++++++++++::::: " + e.getCause().getCause().getMessage());
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Voucher: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("/country/update/{id}")
    public ResponseEntity<CCountry> updateCountry(@PathVariable("id") Long id, @RequestBody CCountry country) {
        try {
            Optional<CCountry> optCountry = pCCountryService.getCountryById(id);
            if (optCountry.isPresent()) {
                CCountry newCountry = optCountry.get();
                newCountry.setCountryCode(country.getCountryCode());
                newCountry.setCountryName(country.getCountryName());
                newCountry.setRegions(country.getRegions());

                CCountry savedCountry = pCCountryService.updateCountry(newCountry);
                return new ResponseEntity<CCountry>(savedCountry, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/country/update2/{id}")
    public ResponseEntity<Object> updateCountry2(@PathVariable("id") Long id, @RequestBody CCountry cCountry) {
        Optional<CCountry> countryData = pCountryRepository.findById(id);
        if (countryData.isPresent()) {
            CCountry newCountry = countryData.get();
            newCountry.setCountryName(cCountry.getCountryName());
            newCountry.setCountryCode(cCountry.getCountryCode());
            newCountry.setRegions(cCountry.getRegions());
            CCountry savedCountry = pCountryRepository.save(newCountry);
            return new ResponseEntity<>(savedCountry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable("id") Long id) {
        try {
            pCCountryService.deleteCountryById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/country/delete2/{id}")
    public ResponseEntity<Object> deleteCountryById2(@PathVariable Long id) {
        try {
            Optional<CCountry> optional = pCountryRepository.findById(id);
            if (optional.isPresent()) {
                pCountryRepository.deleteById(id);
            } else {
                // countryRepository.deleteById(id);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
