package com.devamp.api.task_71adotj0401_crud_classroom_student.controllers;

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

import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CClassroom;
import com.devamp.api.task_71adotj0401_crud_classroom_student.services.CClassroomService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CClassroomController {
    @Autowired
    CClassroomService pClassroomService;

    @GetMapping("/classroom/all")
    public ResponseEntity<List<CClassroom>> getAllClassroom() {
        try {
            return new ResponseEntity<List<CClassroom>>(pClassroomService.getAllClassroom(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classroom/detail/{id}")
    public ResponseEntity<CClassroom> getClassById(@PathVariable("id") Long id) {
        try {
            Optional<CClassroom> dataClass = pClassroomService.getClassroomById(id);
            if (dataClass.isPresent()) {
                return new ResponseEntity<CClassroom>(dataClass.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/classroom/create")
    public ResponseEntity<CClassroom> createClasses(@Valid @RequestBody CClassroom cClassroom) {
        try {
            CClassroom newClassroom = new CClassroom();

            newClassroom.setClassroomCode(cClassroom.getClassroomCode());
            newClassroom.setClassroomName(cClassroom.getClassroomName());
            newClassroom.setTeacherName(cClassroom.getTeacherName());
            newClassroom.setPhoneOfTeacher(cClassroom.getPhoneOfTeacher());
            newClassroom.setStudents(cClassroom.getStudents());

            CClassroom createdClassroom = pClassroomService.createCClassroom(newClassroom);
            return new ResponseEntity<CClassroom>(createdClassroom, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/classroom/update/{id}")
    public ResponseEntity<CClassroom> updateClassroomById(@Valid @PathVariable("id") Long id,
            @RequestBody CClassroom cClassroom) {
        try {
            Optional<CClassroom> dataClassroom = pClassroomService.getClassroomById(id);
            if (dataClassroom.isPresent()) {
                CClassroom newClassroom = dataClassroom.get();

                newClassroom.setClassroomCode(cClassroom.getClassroomCode());
                newClassroom.setClassroomName(cClassroom.getClassroomName());
                newClassroom.setPhoneOfTeacher(cClassroom.getPhoneOfTeacher());
                newClassroom.setTeacherName(cClassroom.getTeacherName());

                newClassroom.setStudents(cClassroom.getStudents());

                CClassroom updatedClassroom = pClassroomService.updateCClassroom(newClassroom);

                return new ResponseEntity<CClassroom>(updatedClassroom, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/classroom/delete/{id}")
    public ResponseEntity<String> deleteClassroomById(@PathVariable("id") Long id) {
        try {
            pClassroomService.deleteCClassroomById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/classroom/check/{id}")
    public ResponseEntity<Object> checkClassroomCode(@PathVariable Long id, @RequestParam String classroomCode) {
        try {
            return new ResponseEntity<>(pClassroomService.checkClassroomCode(id, classroomCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
