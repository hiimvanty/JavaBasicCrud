package com.devcamp.api.task_56bdot40customer_invoice.models;

public class Invoice {
    int id;
    Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return this.customer.id;
    }

    public String getCustomerName() {
        return this.customer.name;
    }

    public int getCustomerDiscount() {
        return this.customer.discount;
    }

    public double getAmountAfterDiscount() {
        return this.amount - this.amount * this.customer.discount / 100;
    }

    @Override
    public String toString() {
        return String.format("Invoice[id=%s, customer=%s(%s)(discount %s%%), amount=%s]",
                this.id, this.customer.name, this.customer.id, this.customer.discount, this.amount);
    }
}
