package com.devcamp.api.task_56cdot40_customer_invoice.models;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getCustomerAfterDiscount() {
        double discount = customer.getDiscount() / 100.0;
        return amount * (1 - discount);
    }

    @Override
    public String toString() {
        return String.format("Invoice[id=%i, customer=%s, amount=%.2f]", id, customer, amount);
    }
}
