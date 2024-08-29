package com.devcamp.api.task_66_crud_province.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_66_crud_province.models.CDistrict;
import com.devcamp.api.task_66_crud_province.repositories.IDistrictRepository;

@Service
public class CDistrictService {

    @Autowired
    IDistrictRepository pDistrictRepository;

    public List<CDistrict> getAllDistrict() {
        return pDistrictRepository.findAll();
    }

    public List<CDistrict> getDistrictByProvinceId(Integer provinceId) {
        return pDistrictRepository.findByProvinceId(provinceId);
    }

    public Optional<CDistrict> getDistrictById(Integer id) {
        return pDistrictRepository.findById(id);
    }

    public CDistrict createDistrict(CDistrict district) {
        return pDistrictRepository.save(district);
    }

    public CDistrict updateDistrict(CDistrict district) {
        return pDistrictRepository.save(district);
    }

    public void deleteDisctrictById(Integer id) {
        pDistrictRepository.deleteById(id);
    }
}
