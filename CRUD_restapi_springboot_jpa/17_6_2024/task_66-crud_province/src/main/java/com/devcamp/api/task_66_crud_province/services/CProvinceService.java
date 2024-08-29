package com.devcamp.api.task_66_crud_province.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_66_crud_province.models.CProvince;
import com.devcamp.api.task_66_crud_province.repositories.IProvinceRepository;

@Service
public class CProvinceService {
    @Autowired
    IProvinceRepository pProvinceRepository;

    public List<CProvince> getAllProvince() {
        return pProvinceRepository.findAll();
    }

    public Optional<CProvince> getProvinceById(int id) {
        return pProvinceRepository.findById(id);
    }

    public CProvince createProvince(CProvince province) {
        return pProvinceRepository.save(province);
    }

    public CProvince updateProvince(CProvince province) {
        return pProvinceRepository.save(province);
    }

    public void deleteProvinceById(int id) {
        pProvinceRepository.deleteById(id);
    }
}
