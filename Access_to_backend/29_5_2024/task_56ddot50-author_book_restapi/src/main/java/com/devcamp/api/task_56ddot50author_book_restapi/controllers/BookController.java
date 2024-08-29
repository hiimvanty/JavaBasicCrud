package com.devcamp.api.task_56ddot50author_book_restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot50author_book_restapi.models.Book;
import com.devcamp.api.task_56ddot50author_book_restapi.services.BookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return bookService.getBookByIndex(bookId);
    }
}
