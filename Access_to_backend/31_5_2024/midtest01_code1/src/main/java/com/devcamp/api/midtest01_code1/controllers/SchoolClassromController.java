package com.devcamp.api.midtest01_code1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.midtest01_code1.models.Classroom;
import com.devcamp.api.midtest01_code1.models.School;
import com.devcamp.api.midtest01_code1.services.SchoolService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SchoolClassromController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolClassromController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{schoolId}")
    public School getSchoolById(@PathVariable int schoolId) {
        return schoolService.getSchoolById(schoolId);
    }

    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {
        return schoolService.getAllClassrooms();
    }

    @GetMapping("/classrooms/{noNumber}")
    public List<Classroom> getClassroomsWithNoGreaterThan(@PathVariable int noNumber) {
        return schoolService.getAllClassrooms().stream()
                .filter(classroom -> classroom.getNoStudent() > noNumber)
                .collect(Collectors.toList());
    }

    @GetMapping("/students/{noNumber}")
    public List<School> getSchoolsWithTotalStudentGreaterThan(@PathVariable int noNumber) {
        return schoolService.getAllSchools().stream()
                .filter(school -> school.getTotalStudent() > noNumber)
                .collect(Collectors.toList());
    }

}
