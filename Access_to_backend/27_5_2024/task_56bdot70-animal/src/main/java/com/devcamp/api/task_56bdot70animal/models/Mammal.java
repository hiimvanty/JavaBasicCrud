package com.devcamp.api.task_56bdot70animal.models;

public class Mammal extends Animal {
    public Mammal(String name){
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Animal[Mammal[name=?]]", getName());
    }

    
}
