package com.bootcamp.task56c30.rest_api.model;

import java.util.ArrayList;

public class Book {
     private String name;
    private ArrayList<Author> authors;
    private double price;
    private int qty = 0;

    
    
    
    public Book(String name, ArrayList<Author> authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    
    public Book(String name, ArrayList<Author> authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }
    
    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames() {
        StringBuilder authorName = new StringBuilder();
        for (Author author : authors) {
            if(authorName.length() > 0) {
                authorName.append(" ");
            }
            authorName.append(author.getName());
        }
        return authorName.toString();
    }
    @Override
    public String toString() {
        return "Book[name=" + name + ",authors={" + getAuthorNames() + "},price=" + price + ",qty=" + qty + "]";
    }
}
