package com.devamp.api.task_71adotj0401_crud_classroom_student.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devamp.api.task_71adotj0401_crud_classroom_student.models.CStudent;

public interface ICStudentRepository extends JpaRepository<CStudent, Long> {
    List<CStudent> findByClassroomId(Long classroomId);

    List<CStudent> findByStudentCode(String studentCode);

    List<CStudent> findByIdNotAndStudentCode(Long id, String studentCode);
}
