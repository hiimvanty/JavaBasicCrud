package com.devcamp.api.task_56bdot20book_author.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot20book_author.models.Author;
import com.devcamp.api.task_56bdot20book_author.models.Book;

@RestController
@RequestMapping("/api/task_56B.20")
@CrossOrigin
public class BookAuthorController {
    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        // Khởi tạo 3 đối tượng tác giả
        Author author1 = new Author("Author 1", "author1@example.com", 'm');
        Author author2 = new Author("Author 2", "author2@example.com", 'f');
        Author author3 = new Author("Author 3", "author3@example.com", 'm');

        // In thông tin của 3 đối tượng tác giả ra console
        System.out.println(author1.toString());
        System.out.println(author2.toString());
        System.out.println(author3.toString());

        // Khởi tạo 3 đối tượng sách tương ứng với 3 tác giả
        Book book1 = new Book("Book 1", author1, 29.99);
        Book book2 = new Book("Book 2", author2, 19.99);
        Book book3 = new Book("Book 3", author3, 24.99);

        // In thông tin của 3 đối tượng sách ra console
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        // Khởi tạo một ArrayList mới
        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        // Trả về ArrayList chứa các đối tượng sách
        return bookList;
    }
}
