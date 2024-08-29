package com.devcamp.api.task69dot80.controllers;

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

import com.devcamp.api.task69dot80.models.CClass;
import com.devcamp.api.task69dot80.repositories.IClassRepository;
import com.devcamp.api.task69dot80.services.CClassService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CClassController {
    @Autowired
    CClassService pCClassServices;

    @GetMapping("/classes/all")
    public ResponseEntity<List<CClass>> getAllClasses() {
        try {
            return new ResponseEntity<List<CClass>>(pCClassServices.getAllClasses(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classes/detail/{id}")
    public ResponseEntity<CClass> getClassById(@PathVariable("id") Long id) {
        try {
            Optional<CClass> dataClass = pCClassServices.getClassById(id);
            if (dataClass.isPresent()) {
                return new ResponseEntity<CClass>(dataClass.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/classes/create")
    public ResponseEntity<CClass> createClasses(@RequestBody CClass cClass) {
        try {
            CClass newClasses = new CClass();

            newClasses.setClassName(cClass.getClassName());
            newClasses.setTeacherName(cClass.getTeacherName());
            newClasses.setTeacherNumber(cClass.getTeacherNumber());
            newClasses.setStudents(cClass.getStudents());

            CClass createdClasses = pCClassServices.createCClass(newClasses);
            return new ResponseEntity<CClass>(createdClasses, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/classes/update/{id}")
    public ResponseEntity<CClass> updateProvinceById(@PathVariable("id") Long id,
            @RequestBody CClass cClass) {
        try {
            Optional<CClass> dataClass = pCClassServices.getClassById(id);
            if (dataClass.isPresent()) {
                CClass newClasses = dataClass.get();

                newClasses.setClassName(cClass.getClassName());
                newClasses.setTeacherName(cClass.getTeacherName());
                newClasses.setTeacherNumber(cClass.getTeacherNumber());

                newClasses.setStudents(cClass.getStudents());

                CClass updatedClass = pCClassServices.updateCClass(newClasses);
                return new ResponseEntity<CClass>(updatedClass, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/classes/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        try {
            pCClassServices.deleteCClassById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
