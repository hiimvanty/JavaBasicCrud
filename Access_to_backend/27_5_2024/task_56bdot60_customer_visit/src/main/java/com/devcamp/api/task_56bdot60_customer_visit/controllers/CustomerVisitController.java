package com.devcamp.api.task_56bdot60_customer_visit.controllers;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot60_customer_visit.models.Customer;
import com.devcamp.api.task_56bdot60_customer_visit.models.Visit;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerVisitController {
    @GetMapping("/task_56B60-visits")
    public ArrayList<Visit> getVisitList() {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        // Initialize three visit objects corresponding to the three customers
        Visit visit1 = new Visit(customer1.getName(), new Date(14/3/2));
        Visit visit2 = new Visit(customer2.getName(), new Date(14/3/2));
        Visit visit3 = new Visit(customer3.getName(), new Date(14/3/20));

        // Print the visit objects using toString()
        System.out.println(visit1.toString());
        System.out.println(visit2.toString());
        System.out.println(visit3.toString());

        // Create a new ArrayList to store the visits
        ArrayList<Visit> visitList = new ArrayList<>();

        // Add the visit objects to the visitList
        visitList.add(visit1);
        visitList.add(visit2);
        visitList.add(visit3);

        return visitList;
    }
}
