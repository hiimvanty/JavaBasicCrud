package com.bootcamp.task56c30.rest_api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.task56c30.rest_api.model.Author;
import com.bootcamp.task56c30.rest_api.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping("/author-info")
    public Author getAuthorEmail(@RequestParam String email) {
        return authorService.getAuthorEmail(email);
    }
    
    @GetMapping("/author-gender")
    public ArrayList<Author> getGenderAuthor(@RequestParam char gender) {
        return authorService.getGenderAthor(gender);
    }
    
}
