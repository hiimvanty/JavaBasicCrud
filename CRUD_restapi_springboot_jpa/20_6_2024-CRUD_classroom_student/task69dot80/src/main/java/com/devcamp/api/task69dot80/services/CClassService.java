package com.devcamp.api.task69dot80.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task69dot80.models.CClass;
import com.devcamp.api.task69dot80.repositories.IClassRepository;

@Service
public class CClassService {
    @Autowired
    IClassRepository pClassRepository;

    public List<CClass> getAllClasses() {
        return pClassRepository.findAll();
    }

    public Optional<CClass> getClassById(Long id) {
        return pClassRepository.findById(id);
    }

    public CClass createCClass(CClass cClass) {
        return pClassRepository.save(cClass);
    }

    public CClass updateCClass(CClass cClass) {
        return pClassRepository.save(cClass);
    }

    public void deleteCClassById(Long id) {
        pClassRepository.deleteById(id);
    }
}
