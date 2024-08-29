package com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.models.CCar;
import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.models.CCarType;
import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.repository.ICarRepository;
import com.devcamp.api.task_60dot40and50and60_car_cartype_jpa.repository.ICarTypeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class CarAndCarTypeController {
    @Autowired
    ICarRepository pCarRepository;

    @Autowired
    ICarTypeRepository pCarTypeRepository;

    @GetMapping("/cars")
    public ResponseEntity<List<CCar>> getAllCars() {
        try {
            List<CCar> listAllCars = new ArrayList<CCar>();
            pCarRepository.findAll().forEach(listAllCars::add);
            if (listAllCars.size() == 0) {
                return new ResponseEntity<>(listAllCars, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(listAllCars, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cartypes")
    public ResponseEntity<Set<CCarType>> getCarTypeByCarCode(@RequestParam(value = "carCode") String carCode) {
        try {
            CCar vCar = pCarRepository.findByCarCode(carCode);
            if (vCar != null) {
                return new ResponseEntity<>(vCar.getTypes(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
