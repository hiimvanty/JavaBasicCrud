package com.devcamp.api.task_56cdot60_customer_visit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot60_customer_visit.models.Visit;
import com.devcamp.api.task_56cdot60_customer_visit.services.VisitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VisitController {
    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visits")
    public ResponseEntity<List<Visit>> getVisit() {
        List<Visit> visits = visitService.getAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }
}
