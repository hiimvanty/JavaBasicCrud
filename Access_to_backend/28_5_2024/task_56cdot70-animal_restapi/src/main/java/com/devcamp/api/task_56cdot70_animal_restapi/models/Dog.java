package com.devcamp.api.task_56cdot70_animal_restapi.models;

public class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return String.format("Dog[Mammal[Animal[name = %s]]]", getName());
    }
}
