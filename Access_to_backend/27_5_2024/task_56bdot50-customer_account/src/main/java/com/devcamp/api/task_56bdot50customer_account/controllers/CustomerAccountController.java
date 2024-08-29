package com.devcamp.api.task_56bdot50customer_account.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot50customer_account.models.Account;
import com.devcamp.api.task_56bdot50customer_account.models.Customer;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerAccountController {
    @GetMapping("/task_56B.50/accounts")
    public ArrayList<Account> getListAccount() {
        Customer customer1 = new Customer(0, "so 1", 1);
        Customer customer2 = new Customer(2, "so 2", 2);
        Customer customer3 = new Customer(3, "so 3", 3);

        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());

        Account account1 = new Account(1, customer1, 0.5d);
        Account account2 = new Account(2, customer2, 0.5d);
        Account account3 = new Account(3, customer3, 0.5d);

        System.out.println(account1.toString());
        System.out.println(account2.toString());
        System.out.println(account2.toString());

        ArrayList<Account> accountList = new ArrayList<>();

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
    
        return accountList;
    }   
}
