package com.bootcamp.task56c30.rest_api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.task56c30.rest_api.model.Book;
import com.bootcamp.task56c30.rest_api.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        ArrayList<Book> result = bookService.getBooks();
        return result;
    }
    
    @GetMapping("/book-quantity")
    public ArrayList<Book> getBook(@RequestParam int quantily) {
        return bookService.getBook(quantily);
    }
    @GetMapping("/books/{bookId}")
    public Book getIndexBook(@PathVariable int bookId) {
        return bookService.getIndexBook(bookId);
    }
    
}
