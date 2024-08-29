package com.devcamp.api.task_56cdot60_customer_visit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot60_customer_visit.models.Customer;

@Service
public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        Customer customer1 = new Customer("customer1");
        Customer customer2 = new Customer("Custoemr 2");
        Customer customer3 = new Customer("Custoemer 3");

        customers.add(customer1);
        customers.add(customer3);
        customers.add(customer2);

    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
