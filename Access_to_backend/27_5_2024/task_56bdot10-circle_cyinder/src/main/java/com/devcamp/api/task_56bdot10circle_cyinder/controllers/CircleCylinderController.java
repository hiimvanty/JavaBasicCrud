package com.devcamp.api.task_56bdot10circle_cyinder.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot10circle_cyinder.models.Circle;
import com.devcamp.api.task_56bdot10circle_cyinder.models.Cylinder;


@RestController
@RequestMapping("/api")
@CrossOrigin

public class CircleCylinderController {
    @GetMapping("/circle-area/{radius}")
    public double getCircleArea(@PathVariable double radius) {
        Circle circle = new Circle(radius);
        return circle.getArea();
    }

    @GetMapping("/cylinder-volume/{radius}/{height}")
    public double getCylinderVolume(@PathVariable double radius, @PathVariable double height) {
        Cylinder cylinder = new Cylinder(radius, height);
        return cylinder.getVolume();
    }

}
