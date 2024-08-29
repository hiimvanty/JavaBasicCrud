package com.devamp.api.task_71adotj0401_crud_classroom_student.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CClassroom;

public interface ICClassroomRepository extends JpaRepository<CClassroom, Long> {
    List<CClassroom> findByClassroomCode(String classroomCode);

    List<CClassroom> findByIdNotAndClassroomCode(Long id, String classroomCode);
}
