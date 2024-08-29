package com.devcamp.api.task_65dot10and20_crud_country_region.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_65dot10and20_crud_country_region.models.CRegion;
import com.devcamp.api.task_65dot10and20_crud_country_region.repositories.ICRegionRepository;

@Service
public class CRegionService {
    @Autowired
    ICRegionRepository pRegionRepository;

    public List<CRegion> getAllRegion() {
        return pRegionRepository.findAll();
    }

    public List<CRegion> getRegionByCountryId(Long countryId) {
        return pRegionRepository.findByCountryId(countryId);
    }

    public Optional<CRegion> getRegionByRegionId(Long id) {
        return pRegionRepository.findById(id);
    }

    public CRegion createRegion(CRegion region) {
        return pRegionRepository.save(region);
    }

    public CRegion updateRegion(CRegion region) {
        return pRegionRepository.save(region);
    }

    public void deleteRegionById(Long id) {
        pRegionRepository.deleteById(id);
    }
}
