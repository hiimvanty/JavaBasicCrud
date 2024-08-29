package com.devcamp.api.task_56cdot60_customer_visit.services;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot60_customer_visit.models.Customer;
import com.devcamp.api.task_56cdot60_customer_visit.models.Visit;

@Service

public class VisitService {
    private List<Visit> visits;
    private CustomerService customerService;

    public VisitService(CustomerService customerService) {
        this.customerService = customerService;
        visits = new ArrayList<>();
        initializeData();

    }

    public void initializeData() {
        Customer customer1 = customerService.getCustomerByName("customer1");
        Customer customer2 = customerService.getCustomerByName("Custoemr 2");
        Customer customer3 = customerService.getCustomerByName("Custoemer 3");

        visits.add(new Visit(customer1, Date.valueOf("2023-05-01")));
        visits.add(new Visit(customer2, Date.valueOf("2023-06-15")));
        visits.add(new Visit(customer3, Date.valueOf("2023-07-30")));
    }

    public List<Visit> getAllVisits() {
        return visits;
    }

    public List<Visit> getVisitsByCustomer(Customer customer) {
        List<Visit> customerVisits = new ArrayList<>();
        for (Visit visit : visits) {
            if (visit.getCustomer().equals(customer)) {
                customerVisits.add(visit);
            }
        }
        return customerVisits;
    }

}
