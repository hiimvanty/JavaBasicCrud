package com.devcamp.api.task_56cdot70_animal_restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot70_animal_restapi.models.Animal;
import com.devcamp.api.task_56cdot70_animal_restapi.models.Cat;
import com.devcamp.api.task_56cdot70_animal_restapi.models.Dog;

import jakarta.annotation.PostConstruct;

@Service
public class AnimalService {
    private List<Animal> animals = new ArrayList<>();

    public void initAnimals(String catNames, String dogNames) {

        // Split the names and create the animals
        String[] catNameArray = catNames.split(",");
        String[] dogNameArray = dogNames.split(",");

        for (String name : catNameArray) {
            animals.add(new Cat(name));
        }

        for (String name : dogNameArray) {
            animals.add(new Dog(name));
        }
    }

    public List<Cat> getCats() {
        return animals.stream()
                .filter(a -> a instanceof Cat)
                .map(a -> (Cat) a)
                .collect(Collectors.toList());
    }

    public List<Dog> getDogs() {
        return animals.stream()
                .filter(a -> a instanceof Dog)
                .map(a -> (Dog) a)
                .collect(Collectors.toList());
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }

    @PostConstruct
    public void initAnimals() {
        animals = new ArrayList<>();
        animals.add(new Dog("Buddy"));
        animals.add(new Dog("Rover"));
        animals.add(new Cat("Whiskers"));
        animals.add(new Cat("Mittens"));
    }
}
