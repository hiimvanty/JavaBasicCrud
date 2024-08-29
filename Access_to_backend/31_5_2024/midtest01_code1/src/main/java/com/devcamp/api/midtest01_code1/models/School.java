package com.devcamp.api.midtest01_code1.models;

import java.util.ArrayList;

public class School {
    private int id;
    private String name;
    private String address;
    private ArrayList<Classroom> classrooms;

    public School() {

    }

    public School(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classrooms = new ArrayList<>();
    }

    public School(int id, String name, String address, ArrayList<Classroom> classrooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classrooms = classrooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public int getTotalStudent() {
        int total = 0;
        for (Classroom classroom : classrooms) {
            total += classroom.getNoStudent();
        }
        return total;
    }
}
