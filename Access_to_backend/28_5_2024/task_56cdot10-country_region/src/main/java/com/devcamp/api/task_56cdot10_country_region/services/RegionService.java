package com.devcamp.api.task_56cdot10_country_region.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot10_country_region.models.Country;
import com.devcamp.api.task_56cdot10_country_region.models.Region;



@Service
public class RegionService {

    @Autowired
    private CountryService countryService;    

    public Region getRegionByRegionCode(String regionCode){
        Region regionResult = null;
        ArrayList<Country> countries = countryService.getCountries();
        // Lay danh sach region
        ArrayList<Region> regions = new ArrayList<Region>();
        for (Country country : countries){
            regions.addAll(country.getRegions());
        }

        // tim kiem region
        Optional<Region> optRegions = regions.stream().filter(item->item.getRegionCode().equals(regionCode)).findFirst();
        if (optRegions.isPresent())
            regionResult = optRegions.get();        

        return regionResult;
    }
}

