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
import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CStudent;
import com.devamp.api.task_71adotj0401_crud_classroom_student.services.CClassroomService;
import com.devamp.api.task_71adotj0401_crud_classroom_student.services.CStudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CStudentController {
    @Autowired
    CStudentService pStudentService;

    @Autowired
    CClassroomService pClassroomService;

    @GetMapping("/student/all")
    public ResponseEntity<List<CStudent>> getAllStudent() {
        try {
            return new ResponseEntity<List<CStudent>>(pStudentService.getAllCStudent(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classroom/{classroomId}/students")
    public ResponseEntity<List<CStudent>> getStudentByClassroomId(
            @PathVariable(value = "classroomId") Long classroomId) {
        try {
            return new ResponseEntity<List<CStudent>>(pStudentService.getStudentByClassroomId(classroomId),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/student/detail/{id}")
    public ResponseEntity<CStudent> getStudentById(@PathVariable("id") Long id) {
        try {
            Optional<CStudent> studentData = pStudentService.getStudentById(id);
            if (studentData.isPresent()) {
                return new ResponseEntity<CStudent>(studentData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/student/create/{id}")
    public ResponseEntity<Object> createStudent(@Valid @PathVariable("id") Long id, @RequestBody CStudent student) {
        try {
            Optional<CClassroom> classroomData = pClassroomService.getClassroomById(id);
            if (classroomData.isPresent()) {

                CStudent newStudent = new CStudent();
                newStudent.setStudentCode(student.getStudentCode());
                newStudent.setStudentName(student.getStudentName());
                newStudent.setGender(student.getGender());
                newStudent.setAddress(student.getAddress());
                newStudent.setDateOfBirth(student.getDateOfBirth());
                newStudent.setStudentPhone(student.getStudentPhone());

                CClassroom _classroom = classroomData.get();
                newStudent.setClassroom(_classroom);

                CStudent savedStudent = pStudentService.createCStudent(newStudent);

                return new ResponseEntity<>(savedStudent, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<CStudent> updateCStudent(@PathVariable("id") Long id, @RequestBody CStudent student) {
        try {
            Optional<CStudent> studentData = pStudentService.getStudentById(id);
            if (studentData.isPresent()) {

                CStudent newCStudent = studentData.get();
                newCStudent.setStudentCode(student.getStudentCode());
                newCStudent.setStudentName(student.getStudentName());
                newCStudent.setGender(student.getGender());
                newCStudent.setAddress(student.getAddress());
                newCStudent.setDateOfBirth(student.getDateOfBirth());
                newCStudent.setStudentPhone(student.getStudentPhone());

                CStudent savedCStudent = pStudentService.updateCStudent(newCStudent);

                return new ResponseEntity<CStudent>(savedCStudent, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        try {
            pStudentService.deleteCStudentById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/check/{id}")
    public ResponseEntity<Object> checkStudentCode(@PathVariable Long id, @RequestParam String studentCode) {
        try {
            return new ResponseEntity<>(pStudentService.checkStudentCode(id, studentCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
