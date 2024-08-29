package com.devamp.api.task_71adotj0401_crud_classroom_student.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "class_rooms")
public class CClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classroom_code", unique = true, nullable = false)
    @NotEmpty(message = "ClassroomCode must be not Empty")
    private String classroomCode;

    @Column(name = "classroom_name", nullable = false)
    @NotEmpty(message = "classroomName must be not Empty")
    private String classroomName;

    @Column(name = "teacher_name", nullable = false)
    @NotEmpty(message = "teacherName must be not Empty")
    private String teacherName;

    @Column(name = "phone_of_teacher", nullable = false)
    @NotEmpty(message = "phoneOfTeacher must be not Empty")
    private String phoneOfTeacher;

    @OneToMany(targetEntity = CStudent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id")
    @JsonManagedReference
    private Set<CStudent> students;

    public CClassroom() {
        super();
    }

    public CClassroom(Long id, String classroomCode, String classroomName, String teacherName, String phoneOfTeacher,
            Set<CStudent> students) {
        super();
        this.id = id;
        this.classroomCode = classroomCode;
        this.classroomName = classroomName;
        this.teacherName = teacherName;
        this.phoneOfTeacher = phoneOfTeacher;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneOfTeacher() {
        return phoneOfTeacher;
    }

    public void setPhoneOfTeacher(String phoneOfTeacher) {
        this.phoneOfTeacher = phoneOfTeacher;
    }

    public Set<CStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<CStudent> students) {
        this.students = students;
    }

}
