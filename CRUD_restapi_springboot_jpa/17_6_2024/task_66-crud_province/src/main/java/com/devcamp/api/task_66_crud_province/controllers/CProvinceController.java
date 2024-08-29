package com.devcamp.api.task_66_crud_province.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_66_crud_province.models.CProvince;
import com.devcamp.api.task_66_crud_province.services.CProvinceService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CProvinceController {
    @Autowired
    CProvinceService pProvinceService;

    @GetMapping("/province/all")
    public ResponseEntity<List<CProvince>> getAllProvince() {
        try {
            return new ResponseEntity<List<CProvince>>(pProvinceService.getAllProvince(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/province/detail/{id}")
    public ResponseEntity<CProvince> getProvinceById(@PathVariable("id") int id) {
        try {
            Optional<CProvince> dataProvince = pProvinceService.getProvinceById(id);
            if (dataProvince.isPresent()) {
                return new ResponseEntity<CProvince>(dataProvince.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/province/create")
    public ResponseEntity<CProvince> createProvince(@RequestBody CProvince province) {
        try {
            CProvince newProvince = new CProvince();

            newProvince.setCode(province.getCode());
            newProvince.setName(province.getName());
            newProvince.setDistricts(province.getDistricts());

            CProvince createdProvince = pProvinceService.createProvince(newProvince);
            return new ResponseEntity<CProvince>(createdProvince, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/province/update/{id}")
    public ResponseEntity<CProvince> updateProvinceById(@PathVariable("id") Integer id,
            @RequestBody CProvince province) {
        try {
            Optional<CProvince> dataProvince = pProvinceService.getProvinceById(id);
            if (dataProvince.isPresent()) {
                CProvince newProvince = dataProvince.get();

                newProvince.setCode(province.getCode());
                newProvince.setName(province.getName());
                newProvince.setDistricts(province.getDistricts());
                
                CProvince updatedProvince = pProvinceService.updateProvince(newProvince);
                return new ResponseEntity<CProvince>(updatedProvince, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/province/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Integer id) {
        try {
            pProvinceService.deleteProvinceById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
