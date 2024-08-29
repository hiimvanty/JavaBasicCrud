package com.devcamp.api.task_56cdot70_animal_restapi.models;

public class Cat extends Mammal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return String.format("Cat[Mammal[Animal[name = %s]]]", getName());
    }
}
