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
import com.devcamp.api.task_66_crud_province.models.CWard;
import com.devcamp.api.task_66_crud_province.services.CDistrictService;
import com.devcamp.api.task_66_crud_province.services.CWardService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CWardController {
    @Autowired
    CWardService pWardService;

    @Autowired
    CDistrictService pDistrictService;

    @GetMapping("/ward/all")
    public ResponseEntity<List<CWard>> getAllWard() {
        try {
            return new ResponseEntity<List<CWard>>(pWardService.getAllWard(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/district/{districtId}/wards")
    public ResponseEntity<List<CWard>> getWardByDistrictId(
            @PathVariable(value = "districtId") Integer districtId) {
        try {
            return new ResponseEntity<List<CWard>>(pWardService.getWardByDistrictId(districtId),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/ward/detail/{id}")
    public ResponseEntity<CWard> getWardById(@PathVariable("id") Integer id) {
        try {
            Optional<CWard> wardData = pWardService.getWardById(id);
            if (wardData.isPresent()) {
                return new ResponseEntity<CWard>(wardData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ward/create/{id}")
    public ResponseEntity<Object> createWard(@PathVariable("id") Integer id, @RequestBody CWard ward) {
        try {
            Optional<CDistrict> districtData = pDistrictService.getDistrictById(id);
            if (districtData.isPresent()) {

                CWard newWard = new CWard();
                newWard.setName(ward.getName());
                newWard.setPrefix(ward.getPrefix());

                CDistrict _dictrict = districtData.get();
                newWard.setDistrict(_dictrict);

                CWard createdWard = pWardService.createWard(newWard);
                return new ResponseEntity<Object>(createdWard, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ward/update/{id}")
    public ResponseEntity<CWard> updateWard(@PathVariable("id") Integer id, @RequestBody CWard ward) {
        try {
            Optional<CWard> wardData = pWardService.getWardById(id);
            if (wardData.isPresent()) {

                CWard newWard = wardData.get();
                newWard.setName(ward.getName());
                newWard.setPrefix(ward.getPrefix());

                CWard saveWard = pWardService.updateWard(newWard);

                return new ResponseEntity<CWard>(saveWard, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ward/delete/{id}")
    public ResponseEntity<String> deleteWard(@PathVariable("id") Integer id) {
        try {
            pWardService.deleteWareById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
