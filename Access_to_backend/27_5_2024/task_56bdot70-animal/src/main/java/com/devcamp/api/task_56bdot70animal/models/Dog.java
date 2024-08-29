package com.devcamp.api.task_56bdot70animal.models;

public class Dog extends Mammal {
    public Dog(String name){
        super(name);
    }

    public void greets(){
        System.out.println("The dog says: gau gau!");
    }

    public void greets(Dog another){
        System.out.println("The dog says: gau gau, gau gau gau!");
    }

}
