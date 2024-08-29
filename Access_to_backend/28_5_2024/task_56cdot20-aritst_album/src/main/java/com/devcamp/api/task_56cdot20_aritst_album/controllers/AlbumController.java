package com.devcamp.api.task_56cdot20_aritst_album.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.task_56cdot20_aritst_album.models.Album;
import com.devcamp.api.task_56cdot20_aritst_album.services.AlbumService;

@RequestMapping("/albums")
@RestController
@CrossOrigin
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums-info")
    public Album getAlbumById(@RequestParam("albumId") int albumId) {
        return albumService.getAlbumById(albumId);
    }
}
