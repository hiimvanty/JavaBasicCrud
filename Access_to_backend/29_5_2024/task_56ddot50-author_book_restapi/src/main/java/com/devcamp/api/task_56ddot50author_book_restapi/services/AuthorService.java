package com.devcamp.api.task_56ddot50author_book_restapi.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56ddot50author_book_restapi.models.Author;
import com.devcamp.api.task_56ddot50author_book_restapi.models.Book;

@Service
public class AuthorService {
    private ArrayList<Author> authors;

    public AuthorService(){
        authors = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        Author author1 = new Author("Nguyen Van Ty", "hiimvanty@gmail.com", 'm');
        authors.add(author1);

    }
    public ArrayList<Author> getAllAuthors(){
        return authors;
    }
}
