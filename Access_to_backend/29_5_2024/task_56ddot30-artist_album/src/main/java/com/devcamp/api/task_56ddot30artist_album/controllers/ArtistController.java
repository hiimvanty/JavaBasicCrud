package com.devcamp.api.task_56ddot30artist_album.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56ddot30artist_album.models.Artist;
import com.devcamp.api.task_56ddot30artist_album.services.ArtistService;

@RestController
@CrossOrigin
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;
    @GetMapping
    public  ArrayList<Artist> getAllArtist(){
        return artistService.getAllArtists();
    }
    @GetMapping("/{index}")
    public Artist getArtistByIndex(@PathVariable int index){
        return artistService.getArtistByIndex(index);
    }
}
