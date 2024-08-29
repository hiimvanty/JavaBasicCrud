package com.devcamp.api.task_56bdot70animal.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot70animal.models.Cat;
import com.devcamp.api.task_56bdot70animal.models.Dog;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AnimalController {
    @GetMapping("/task_56b70-cats")
    public ArrayList<Cat> getCatList() {
        ArrayList<Cat> cats = new ArrayList<>();

        // Khởi tạo và thêm các đối tượng Cat vào ArrayList
        Cat cat1 = new Cat("Milo");
        Cat cat2 = new Cat("Luna");
        Cat cat3 = new Cat("Simba");

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        return cats;
    }

    @GetMapping("/task_56b70-dogs")
    public ArrayList<Dog> getDogs() {
        ArrayList<Dog> dogs = new ArrayList<>();

        // Khởi tạo và thêm các đối tượng Dog vào ArrayList
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Max");
        Dog dog3 = new Dog("Charlie");

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        return dogs;
    }
}
