package com.devcamp.api.task69dot80.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamp.api.task69dot80.models.Student;
import com.devcamp.api.task69dot80.repositories.IStudentRepository;

@Service
public class StudentService {
    @Autowired
    IStudentRepository pStudentRepository;

    public List<Student> getAllStudent() {
        return pStudentRepository.findAll();
    }

    public List<Student> getStudentByClassId(Long classId) {
        return pStudentRepository.findByCClassId(classId);
    }

    public Optional<Student> getStudentById(Long id) {
        return pStudentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return pStudentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return pStudentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        pStudentRepository.deleteById(id);
    }
}
