package com.devcamp.api.task69dot80.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.task69dot80.models.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCClassId(Long classId);
}
