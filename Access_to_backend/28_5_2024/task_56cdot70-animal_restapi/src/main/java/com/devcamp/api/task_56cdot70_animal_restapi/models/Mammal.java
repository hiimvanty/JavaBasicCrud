package com.devcamp.api.task_56cdot70_animal_restapi.models;

public abstract class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return String.format("Mammal[Animal[name = %s]]", getName());
    }
}
