package com.devcamp.api.task_65dot10and20_crud_country_region.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_65dot10and20_crud_country_region.models.CCountry;
import com.devcamp.api.task_65dot10and20_crud_country_region.repositories.ICCountryRepository;

@Service
public class CCountryService {
    @Autowired
    ICCountryRepository pCountryRepository;

    public CCountry findByCountryCode(String countryCode) {
        return pCountryRepository.findByCountryCode(countryCode);
    }

    public List<CCountry> getAllCountries() {
        return pCountryRepository.findAll();
    }

    public List<CCountry> getCountryList() {
        List<CCountry> listCountries = new ArrayList<>();
        pCountryRepository.findAll().forEach(listCountries::add);
        return listCountries;
    }

    public Optional<CCountry> getCountryById(Long id) {
        return pCountryRepository.findById(id);
    }

    public Optional<CCountry> getCountryByIdVer2(Long id) {
        return pCountryRepository.findAll().stream()
                .filter(country -> country.getId().equals(id))
                .findFirst();
    }

    public CCountry createCountry(CCountry cCountry) {
        return pCountryRepository.save(cCountry);
    }

    public CCountry updateCountry(CCountry country) {
        return pCountryRepository.save(country);
    }

    public void deleteCountryById(Long id) {
        pCountryRepository.deleteById(id);
    }
}
