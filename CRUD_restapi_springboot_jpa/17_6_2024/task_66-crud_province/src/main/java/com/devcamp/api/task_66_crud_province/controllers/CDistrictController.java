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
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_66_crud_province.models.CDistrict;
import com.devcamp.api.task_66_crud_province.models.CProvince;
import com.devcamp.api.task_66_crud_province.repositories.IProvinceRepository;
import com.devcamp.api.task_66_crud_province.services.CDistrictService;
import com.devcamp.api.task_66_crud_province.services.CProvinceService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CDistrictController {
    @Autowired
    CDistrictService pDistrictService;

    @Autowired
    CProvinceService pProvinceService;

    @Autowired
    IProvinceRepository pIProvinceRepository;

    @GetMapping("/district/all")
    public ResponseEntity<List<CDistrict>> getALlDistrict() {
        try {
            return new ResponseEntity<List<CDistrict>>(pDistrictService.getAllDistrict(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/province/{provinceId}/districts")
    public ResponseEntity<List<CDistrict>> getDistrictByProvineId(
            @PathVariable(value = "provinceId") Integer provinceId) {
        try {
            return new ResponseEntity<List<CDistrict>>(pDistrictService.getDistrictByProvinceId(provinceId),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/district/detail/{id}")
    public ResponseEntity<CDistrict> getDistrictById(@PathVariable("id") Integer id) {
        try {
            Optional<CDistrict> districtData = pDistrictService.getDistrictById(id);
            if (districtData.isPresent()) {
                return new ResponseEntity<CDistrict>(districtData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/district/create/{id}")
    public ResponseEntity<Object> createDistrict(@PathVariable("id") int id, @RequestBody CDistrict district) {
        try {
            Optional<CProvince> provinceData = pProvinceService.getProvinceById(id);
            if (provinceData.isPresent()) {

                CDistrict newDistrict = new CDistrict();
                newDistrict.setName(district.getName());
                newDistrict.setPrefix(district.getPrefix());
                newDistrict.setWards(district.getWards());

                CProvince _province = provinceData.get();
                newDistrict.setProvince(_province);

                CDistrict createdDistrict = pDistrictService.createDistrict(newDistrict);

                return new ResponseEntity<>(createdDistrict, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/district/update/{id}")
    public ResponseEntity<CDistrict> updateDistrict(@PathVariable("id") Integer id, @RequestBody CDistrict district) {
        try {
            Optional<CDistrict> districtData = pDistrictService.getDistrictById(id);
            if (districtData.isPresent()) {

                CDistrict newDistrict = districtData.get();
                newDistrict.setName(district.getName());
                newDistrict.setPrefix(district.getPrefix());
                newDistrict.setWards(district.getWards());

                CDistrict savedDistrict = pDistrictService.updateDistrict(newDistrict);

                return new ResponseEntity<CDistrict>(savedDistrict, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/district/delete/{id}")
    public ResponseEntity<String> deleteRegionById(@PathVariable("id") Integer id) {
        try {
            pDistrictService.deleteDisctrictById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
