package com.devcamp.api.midtest01_code1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devcamp.api.midtest01_code1.models.Classroom;
import com.devcamp.api.midtest01_code1.models.School;

@Service
public class SchoolService {
    private List<School> schools;

    public SchoolService() {
        schools = new ArrayList<>();

        School school1 = new School(1, "School 1", "Ho Chi Minh");
        school1.getClassrooms().add(new Classroom(1, "Classroom 1", 61));
        school1.getClassrooms().add(new Classroom(2, "Classroom 2", 20));
        school1.getClassrooms().add(new Classroom(3, "Classroom 3", 31));

        School school2 = new School(2, "School 2", "Hoi An");
        school2.getClassrooms().add(new Classroom(4, "Classroom 4", 13));
        school2.getClassrooms().add(new Classroom(5, "Classroom 5", 17));
        school2.getClassrooms().add(new Classroom(6, "Classroom 6", 19));

        School school3 = new School(1, "School 3", "Da Nang");
        school3.getClassrooms().add(new Classroom(7, "Classroom 7", 30));
        school3.getClassrooms().add(new Classroom(8, "Classroom 8", 90));
        school3.getClassrooms().add(new Classroom(9, "Classroom 9", 270));

        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
    }

    public List<School> getAllSchools() {
        return schools;
    }

    public School getSchoolById(int schoolId) {
        for (School school : schools) {
            if (school.getId() == schoolId) {
                return school;
            }
        }
        return null; // Trả về null nếu không tìm thấy schoolId tương ứng
    }

    public List<Classroom> getAllClassrooms() {
        List<Classroom> allClassrooms = new ArrayList<>();
        for (School school : schools) {
            allClassrooms.addAll(school.getClassrooms());
        }
        return allClassrooms;
    }

    public List<Classroom> getClassroomsWithMoreStudentsThan(int noNumber) {
        List<Classroom> classroomsWithMoreStudents = new ArrayList<>();
        for (School school : schools) {
            for (Classroom classroom : school.getClassrooms()) {
                if (classroom.getNoStudent() > noNumber) {
                    classroomsWithMoreStudents.add(classroom);
                }
            }
        }
        return classroomsWithMoreStudents;
    }

    public List<School> getSchoolsWithMoreStudentsThan(int noNumber) {
        List<School> schoolsWithMoreStudents = new ArrayList<>();
        for (School school : schools) {
            int totalStudents = school.getTotalStudent();
            if (totalStudents > noNumber) {
                schoolsWithMoreStudents.add(school);
            }
        }
        return schoolsWithMoreStudents;
    }

}
