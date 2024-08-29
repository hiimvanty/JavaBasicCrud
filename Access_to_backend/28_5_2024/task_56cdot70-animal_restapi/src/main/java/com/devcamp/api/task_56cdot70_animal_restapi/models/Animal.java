package com.devcamp.api.task_56cdot70_animal_restapi.models;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + "]";
    }

}
