package com.devcamp.api.task_56bdot50customer_account.models;

public class Account {
    private int id;
    private Customer customer;
    private double balance = 0.0d;

    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", customer=" + customer + ", balance=" + balance + "]";
    }

    public String getCustomerName() {
        return this.customer.name;
    }

    public Account deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
        return this;
    }

    public Account withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Amount withdraw exceeds the current balance!");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
        return this;
    }

}
