package com.devamp.api.task_71adotj0401_crud_classroom_student.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class CStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "student_code", unique = true)
    @NotNull(message = "StudentCode must not be Empty")
    private String studentCode;

    @Column(nullable = false, name = "student_name")
    @NotNull(message = "studentName must not be Empty")
    private String studentName;

    @Column(nullable = false, name = "gender")
    @NotNull(message = "gender must not be Empty")
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, name = "date_of_birth", updatable = true)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    @Column(nullable = false, name = "address")
    @NotNull(message = "address must not be Empty")
    private String address;

    @Column(nullable = false, name = "student_phone")
    @NotNull(message = "studentPhone must not be Empty")
    private String studentPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    @JsonBackReference
    private CClassroom classroom;

    public CStudent() {
        super();
    }

    public CStudent(Long id, String studentCode, String studentName, String gender, Date dateOfBirth, String address,
            String studentPhone) {
        super();
        this.id = id;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.studentPhone = studentPhone;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public CClassroom getClassroom() {
        return classroom;
    }

    public void setClassroom(CClassroom classroom) {
        this.classroom = classroom;
    }

}
