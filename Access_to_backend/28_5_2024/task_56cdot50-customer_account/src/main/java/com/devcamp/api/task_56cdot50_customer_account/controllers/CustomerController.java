package com.devcamp.api.task_56cdot50_customer_account.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot50_customer_account.models.Account;
import com.devcamp.api.task_56cdot50_customer_account.models.Customer;
import com.devcamp.api.task_56cdot50_customer_account.services.AccountService;
import com.devcamp.api.task_56cdot50_customer_account.services.CustomerService;

@RequestMapping("/api")
@RestController
@CrossOrigin

public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
        ArrayList<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }
}
