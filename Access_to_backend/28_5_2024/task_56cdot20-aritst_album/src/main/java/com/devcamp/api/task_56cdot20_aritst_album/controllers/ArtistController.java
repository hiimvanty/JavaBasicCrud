package com.devcamp.api.task_56cdot20_aritst_album.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot20_aritst_album.models.Artist;
import com.devcamp.api.task_56cdot20_aritst_album.services.ArtistService;

@RequestMapping("/artists")
@RestController
@CrossOrigin
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ArrayList<Artist> getAllArtist() {
        return artistService.getAllArtists();
    }

    @GetMapping("/artist-info")
    public Artist getArtistById(@RequestParam("artistId") int artistId) {
        return artistService.getArtistById(artistId);
    }
}
