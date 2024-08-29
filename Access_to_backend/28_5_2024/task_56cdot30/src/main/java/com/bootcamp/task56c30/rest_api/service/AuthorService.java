package com.bootcamp.task56c30.rest_api.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bootcamp.task56c30.rest_api.model.Author;

@Service
public class AuthorService {
    private Author author1 = new Author("Phuc", "phuc@gmail.com", 'M');
    private Author author2 = new Author("Pham", "pham@gmail.com", 'M');
    private Author author3 = new Author("Danh", "danh@gmail.com", 'M');
    private Author author4 = new Author("Trung", "trung@gmail.com", 'M');
    private Author author5 = new Author("Dao", "dao@gmail.com", 'F');
    private Author author6 = new Author("Mai", "mai@gmail.com", 'F');

    public ArrayList<Author> geAuthor1() {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        return authors;
    }
    public ArrayList<Author> geAuthor2() {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author3);
        authors.add(author4);
        return authors;
    }
    public ArrayList<Author> geAuthor3() {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author5);
        authors.add(author6);
        return authors;
    }

    public Author getAuthorEmail(String email) {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);

        for (Author author : authors) {
            if(author.getEmail().equals(email)) {
                return author;
            }
        }
        return null;
    }

    public ArrayList<Author> getGenderAthor(char gender) {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);
        ArrayList<Author> result = new ArrayList<>();

        for (Author author : authors) {
            if(author.getGender() == gender) {
                result.add(author);
            }
        }
        return result;

    }
}
