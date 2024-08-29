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
import com.devcamp.api.task69dot80.models.Student;
import com.devcamp.api.task69dot80.services.CClassService;
import com.devcamp.api.task69dot80.services.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService pStudentService;

    @Autowired
    CClassService pClassService;

    @GetMapping("/students/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        try {
            return new ResponseEntity<List<Student>>(pStudentService.getAllStudent(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classes/{classId}/students")
    public ResponseEntity<List<Student>> getStudentByClassId(
            @PathVariable(value = "classId") Long classId) {
        try {
            return new ResponseEntity<List<Student>>(pStudentService.getStudentByClassId(classId),
                    HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/students/detail/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        try {
            Optional<Student> studentData = pStudentService.getStudentById(id);
            if (studentData.isPresent()) {
                return new ResponseEntity<Student>(studentData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/students/create/{id}")
    public ResponseEntity<Object> createStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        try {
            Optional<CClass> classData = pClassService.getClassById(id);
            if (classData.isPresent()) {

                Student newStudent = new Student();
                newStudent.setAddress(student.getAddress());
                newStudent.setDateOfBirth(student.getDateOfBirth());
                newStudent.setGender(student.getGender());
                newStudent.setName(student.getName());
                newStudent.setPhone(student.getPhone());

                CClass _class = classData.get();
                newStudent.setcClass(_class);

                Student createdStudent = pStudentService.createStudent(newStudent);
                return new ResponseEntity<>(createdStudent, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/students/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        try {
            Optional<Student> studentData = pStudentService.getStudentById(id);
            if (studentData.isPresent()) {

                Student newStudent = studentData.get();
                newStudent.setAddress(student.getAddress());
                newStudent.setDateOfBirth(student.getDateOfBirth());
                newStudent.setGender(student.getGender());
                newStudent.setName(student.getName());
                newStudent.setPhone(student.getPhone());

                Student savedStudent = pStudentService.updateStudent(newStudent);

                return new ResponseEntity<Student>(savedStudent, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        try {
            pStudentService.deleteStudentById(id);
            return new ResponseEntity<String>("Da xoa thanh cong", HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
