package com.devcamp.api.task_56bdot30book_author_v2dot0.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56bdot30book_author_v2dot0.models.Author;
import com.devcamp.api.task_56bdot30book_author_v2dot0.models.Book;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class BookAuthorController {
    @GetMapping("/task_56B.30/books")

    public ArrayList<Book> getBooks(){
        Author author1 = new Author("Author 1", "author1@example.com", 'm');
        Author author2 = new Author("Author 2", "author2@example.com", 'f');
        Author author3 = new Author("Author 3", "author3@example.com", 'm');
        Author author4 = new Author("Author 4", "author4@example.com", 'f');
        Author author5 = new Author("Author 5", "author5@example.com", 'm');
        Author author6 = new Author("Author 6", "author6@example.com", 'f');

        // In thông tin 6 đối tượng tác giả ra console
        System.out.println(author1.toString());
        System.out.println(author2.toString());
        System.out.println(author3.toString());
        System.out.println(author4.toString());
        System.out.println(author5.toString());
        System.out.println(author6.toString());

        // Khởi tạo 3 ArrayList mới để chứa tác giả
        ArrayList<Author> authorList1 = new ArrayList<>();
        ArrayList<Author> authorList2 = new ArrayList<>();
        ArrayList<Author> authorList3 = new ArrayList<>();

        // Thêm tác giả vào từng ArrayList
        authorList1.add(author1);
        authorList1.add(author2);

        authorList2.add(author3);
        authorList2.add(author4);

        authorList3.add(author5);
        authorList3.add(author6);

        // Khởi tạo 3 đối tượng sách với các danh sách tác giả tương ứng
        Book book1 = new Book("Book 1", authorList1.toArray(new Author[0]), 29.99);
        Book book2 = new Book("Book 2", authorList2.toArray(new Author[0]), 19.99);
        Book book3 = new Book("Book 3", authorList3.toArray(new Author[0]), 24.99);

        // In thông tin 3 đối tượng sách ra console
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        // Khởi tạo một ArrayList mới để chứa các đối tượng sách
        ArrayList<Book> bookList = new ArrayList<>();

        // Thêm các đối tượng sách vào ArrayList
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        // Trả về ArrayList chứa các đối tượng sách
        return bookList;
    }
}
