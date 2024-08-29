package com.devcamp.api.task_56ddot60custumer_invoice.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56ddot60custumer_invoice.models.Customer;

@Service
public class CustomerService {
    private ArrayList<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        Customer customer1 = new Customer(0, "customer1", 20);
        Customer customer2 = new Customer(1, "customer2", 20);
        Customer customer3 = new Customer(2, "customer3", 20);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

    }
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
}
