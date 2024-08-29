package com.devcamp.api.task_56ddot50author_book_restapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56ddot50author_book_restapi.models.Author;
import com.devcamp.api.task_56ddot50author_book_restapi.models.Book;

@Service
public class BookService {

    private ArrayList<Book> books;

    public BookService(){
        books = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        // Tạo danh sách các tác giả
        Author author1 = new Author("Author 1", "author1@example.com", 'M');
        Author author2 = new Author("Author 2", "author2@example.com", 'F');
        Author author3 = new Author("Author 3", "author3@example.com", 'M');

        // Tạo danh sách sách
        Book book1 = new Book("Book 1", new Author[] { author1, author2 }, 19.99);
        Book book2 = new Book("Book 2", new Author[] { author1, author3 }, 29.99);
        Book book3 = new Book("Book 3", new Author[] { author2, author3 }, 39.99);

        // Thêm sách vào danh sách
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }
    public ArrayList<Book> getAllBook(){
        return books;
    }
    public Book getBookByIndex(int index){
        if(index >= 0 && index <books.size()){
            return books.get(index);
        }
        return null;
    }
}
