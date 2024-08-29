package com.devcamp.api.task_66_crud_province.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task_66_crud_province.models.CWard;
import com.devcamp.api.task_66_crud_province.repositories.IWardRepository;

@Service
public class CWardService {
    @Autowired
    IWardRepository pWardRepository;

    public List<CWard> getAllWard() {
        return pWardRepository.findAll();
    }

    public List<CWard> getWardByDistrictId(Integer districtId) {
        return pWardRepository.findByDistrictId(districtId);
    }

    public Optional<CWard> getWardById(Integer id) {
        return pWardRepository.findById(id);
    }

    public CWard createWard(CWard ward) {
        return pWardRepository.save(ward);
    }

    public CWard updateWard(CWard ward) {
        return pWardRepository.save(ward);
    }

    public void deleteWareById(Integer id) {
        pWardRepository.deleteById(id);
    }
}
