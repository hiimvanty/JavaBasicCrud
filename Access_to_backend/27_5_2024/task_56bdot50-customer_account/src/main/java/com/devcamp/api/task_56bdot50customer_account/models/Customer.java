package com.devcamp.api.task_56bdot50customer_account.models;

public class Customer {
    int id;
    String name;
    int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("Name(id = %s)(discount = %s%%)", id, discount);
    }
}
