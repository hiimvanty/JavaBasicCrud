package com.devcamp.api.task_56bdot70animal.models;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

}
