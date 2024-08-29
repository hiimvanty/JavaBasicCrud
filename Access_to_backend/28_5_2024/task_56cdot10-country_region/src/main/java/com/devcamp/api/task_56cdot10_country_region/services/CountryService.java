package com.devcamp.api.task_56cdot10_country_region.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot10_country_region.models.Country;
import com.devcamp.api.task_56cdot10_country_region.models.Region;

@Service
public class CountryService {
    ArrayList<Country> data;

    

    public CountryService() {
        initData();
    }

    private void initData(){
        data = new ArrayList<Country>();

        // Viet Nam
        ArrayList<Region> vnRegions = new ArrayList<Region>();
        vnRegions.add(new Region("HN", "Hà Nội"));
        vnRegions.add(new Region("HCM", "Hồ Chí Minh"));
        data.add(new Country("VN","Việt Nam",vnRegions));

        // USA
        ArrayList<Region> usaRegions = new ArrayList<Region>();
        usaRegions.add(new Region("NY", "Newyork"));
        usaRegions.add(new Region("BS", "Boston"));
        data.add(new Country("US","Mỹ",usaRegions));

        // England
        ArrayList<Region> engRegions = new ArrayList<Region>();
        engRegions.add(new Region("EA", "East of England"));
        engRegions.add(new Region("LD", "London"));
        data.add(new Country("UK","Anh quốc",engRegions));
    }

    public ArrayList<Country> getCountries(){
        return data;
    }

    public Country getCountryByCountryCode(String countryCode){
        boolean found = false;
        Country countryResult = null;
        int index=0;
        
        while(found == false && index < data.size()){
            if (data.get(index).getCountryCode().equals(countryCode)){
                found = true;
                countryResult = data.get(index);
            }
            index++;
        }
        return countryResult;
    }
}


