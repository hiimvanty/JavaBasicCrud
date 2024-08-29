package com.devamp.api.task_71adotj0401_crud_classroom_student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CClassroom;
import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CStudent;
import com.devamp.api.task_71adotj0401_crud_classroom_student.repositories.ICStudentRepository;

@Service
public class CStudentService {
    @Autowired
    ICStudentRepository pStudentRepository;

    public List<CStudent> getAllCStudent() {
        return pStudentRepository.findAll();
    }

    public List<CStudent> getStudentByClassroomId(Long classroomId) {
        return pStudentRepository.findByClassroomId(classroomId);
    }

    public Optional<CStudent> getStudentById(Long id) {
        return pStudentRepository.findById(id);
    }

    public CStudent createCStudent(CStudent cStudent) {
        return pStudentRepository.save(cStudent);
    }

    public CStudent updateCStudent(CStudent cStudent) {
        return pStudentRepository.save(cStudent);
    }

    public void deleteCStudentById(Long id) {
        pStudentRepository.deleteById(id);
    }

    public boolean checkStudentCode(Long studentId, String studentCode) {
        List<CStudent> listStudent;
        if (studentId == 0) {
            listStudent = pStudentRepository.findByStudentCode(studentCode);
        } else {
            listStudent = pStudentRepository.findByIdNotAndStudentCode(studentId, studentCode);
        }

        if (listStudent.isEmpty() || listStudent == null) {
            return false;
        }
        return true;
    }
}
