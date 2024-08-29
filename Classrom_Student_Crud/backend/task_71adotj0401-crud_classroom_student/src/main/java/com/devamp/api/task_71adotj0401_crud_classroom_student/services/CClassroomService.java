package com.devamp.api.task_71adotj0401_crud_classroom_student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CClassroom;
import com.devamp.api.task_71adotj0401_crud_classroom_student.repositories.ICClassroomRepository;

@Service
public class CClassroomService {
    @Autowired
    ICClassroomRepository pClassroomRepository;

    public List<CClassroom> getAllClassroom() {
        return pClassroomRepository.findAll();
    }

    public Optional<CClassroom> getClassroomById(Long id) {
        return pClassroomRepository.findById(id);
    }

    public CClassroom createCClassroom(CClassroom cClassroom) {
        return pClassroomRepository.save(cClassroom);
    }

    public CClassroom updateCClassroom(CClassroom cClassroom) {
        return pClassroomRepository.save(cClassroom);
    }

    public void deleteCClassroomById(Long id) {
        pClassroomRepository.deleteById(id);
    }

    public boolean checkClassroomCode(Long classroomId, String classroomCode) {
        List<CClassroom> listClassroom;
        if (classroomId == 0) {
            listClassroom = pClassroomRepository.findByClassroomCode(classroomCode);
        } else {
            listClassroom = pClassroomRepository.findByIdNotAndClassroomCode(classroomId, classroomCode);
        }

        if (listClassroom.isEmpty() || listClassroom == null) {
            return false;
        }
        return true;
    }
}
