package com.devcamp.api.task_56cdot70_animal_restapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot70_animal_restapi.models.Animal;
import com.devcamp.api.task_56cdot70_animal_restapi.models.Cat;
import com.devcamp.api.task_56cdot70_animal_restapi.models.Dog;
import com.devcamp.api.task_56cdot70_animal_restapi.services.AnimalService;

@RestController
@RequestMapping("/animals")
@CrossOrigin
public class AnimalControllers {
    private final AnimalService animalService;

    public AnimalControllers(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/init")
    public String initAnimals(@RequestParam String catNames, @RequestParam String dogNames) {
        animalService.initAnimals(catNames, dogNames);
        return "Animals initialized successfully.";
    }

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return animalService.getCats();
    }

    @GetMapping("/dogs")
    public List<Dog> getDogs() {
        return animalService.getDogs();
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

}
