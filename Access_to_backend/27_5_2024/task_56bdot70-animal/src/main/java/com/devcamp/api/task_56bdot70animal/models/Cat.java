package com.devcamp.api.task_56bdot70animal.models;

public class Cat extends Mammal {
    public Cat(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("The cat says: Meow!");
    }

    @Override
    public String toString() {
        return String.format("[Animal[Mammal[Cat = ???]]]", getName());
    }

}
