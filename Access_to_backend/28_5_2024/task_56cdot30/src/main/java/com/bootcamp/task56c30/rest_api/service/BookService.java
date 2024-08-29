package com.bootcamp.task56c30.rest_api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.task56c30.rest_api.model.Book;

@Service
public class BookService {
    @Autowired
    AuthorService authorService;

    public ArrayList<Book> getBooks() {
        Book book1 = new Book("Conan", this.authorService.geAuthor1(), 100000);
        Book book2 = new Book("Doremon", this.authorService.geAuthor2(), 200000);
        Book book3 = new Book("OnePice", this.authorService.geAuthor3(), 300000);


        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }

    public ArrayList<Book> getBook(int quantily) {
        Book book1 = new Book("Conan", this.authorService.geAuthor1(), 100000,10);
         Book book2 = new Book("Doremon", this.authorService.geAuthor2(), 200000,20);
         Book book3 = new Book("OnePice", this.authorService.geAuthor3(), 300000,5);


        book1.setAuthors(authorService.geAuthor1());
        book2.setAuthors(authorService.geAuthor2());
        book3.setAuthors(authorService.geAuthor3());

        ArrayList<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);

        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if(book.getQty() >= quantily) {
                result.add(book);
            }
        }
        return result;
    }

    public Book getIndexBook(int index) {
        Book book1 = new Book("Conan", this.authorService.geAuthor1(), 100000);
        Book book2 = new Book("Doremon", this.authorService.geAuthor2(), 200000);
        Book book3 = new Book("OnePice", this.authorService.geAuthor3(), 300000);

        ArrayList<Book> result = new ArrayList<>();
        result.add(book1);
        result.add(book2);
        result.add(book3);

        if(index < 0 || index >= result.size()) {
            return null;
        }
        return result.get(index);
    }
}
