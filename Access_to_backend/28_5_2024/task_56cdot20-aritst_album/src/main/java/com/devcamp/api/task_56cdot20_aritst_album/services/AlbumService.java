package com.devcamp.api.task_56cdot20_aritst_album.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot20_aritst_album.models.Album;

@Service
public class AlbumService {
    private ArrayList<Album> albums;

    public AlbumService() {
        albums = new ArrayList<>();
        initializeData();
    }

    public void initializeData() {
        Album album1 = new Album(1, "Album 1");
        album1.getSongs().add("Song");
        album1.getSongs().add("Song 1.2");
        album1.getSongs().add("Song 1.3");

        // Tạo Album 2
        Album album2 = new Album(2, "Album 2");
        album2.getSongs().add("Song 2.1");
        album2.getSongs().add("Song 2.2");
        album2.getSongs().add("Song 2.3");

        // Tạo Album 3
        Album album3 = new Album(3, "Album 3");
        album3.getSongs().add("Song 3.1");
        album3.getSongs().add("Song 3.2");
        album3.getSongs().add("Song 3.3");

        // Thêm các Album vào danh sách
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);

    }

    public ArrayList<Album> getAllAlbums() {
        return albums;
    }

    public Album getAlbumById(int albumId) {
        for (Album album : albums) {
            if (album.getId() == albumId) {
                return album;
            }
        }
        return null;
    }
}
