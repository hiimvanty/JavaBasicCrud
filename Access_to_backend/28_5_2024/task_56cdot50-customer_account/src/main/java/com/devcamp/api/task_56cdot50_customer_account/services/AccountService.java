package com.devcamp.api.task_56cdot50_customer_account.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot50_customer_account.models.Account;
import com.devcamp.api.task_56cdot50_customer_account.models.Customer;

@Service
public class AccountService {
    private ArrayList<Account> accounts;

    public AccountService(){
        accounts = new ArrayList<>();
        initializaData();
    }

    public void initializaData(){
        CustomerService customerService = new CustomerService();

        ArrayList<Customer> customers = customerService.getAllCustomers();

        Account account1 = new Account(1, customers.get(0), 1000);
        Account account2 = new Account(2, customers.get(1), 2000);
        Account account3 = new Account(2, customers.get(2), 3000);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
    }

    public ArrayList<Account> getAllAccounts(){
        return accounts;
    }
}
