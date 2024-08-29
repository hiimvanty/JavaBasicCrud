package com.devcamp.api.midtest01_code1.models;

public class Classroom {
    private int id;
    private String name;
    private int noStudent;

    public Classroom() {

    }

    public Classroom(int id, String name, int noStudent) {
        this.id = id;
        this.name = name;
        this.noStudent = noStudent;
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

    public int getNoStudent() {
        return noStudent;
    }

    public void setNoStudent(int noStudent) {
        this.noStudent = noStudent;
    }

}
