package com.devcamp.api.task_56ddot30artist_album.controllers;

import com.devcamp.api.task_56ddot30artist_album.models.Album;
import com.devcamp.api.task_56ddot30artist_album.models.Artist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistAlbumController {
    private List<Artist> artists;

    public ArtistAlbumController() {
        // Khởi tạo bộ dữ liệu mẫu
        artists = new ArrayList<>();

        // Tạo Artist 1
        Artist artist1 = new Artist(1, "Artist 1");
        artist1.getAlbums().add(new Album(1, "Album 1.1"));
        artist1.getAlbums().add(new Album(2, "Album 1.2"));
        artist1.getAlbums().add(new Album(3, "Album 1.3"));

        // Tạo Artist 2
        Artist artist2 = new Artist(2, "Artist 2");
        artist2.getAlbums().add(new Album(4, "Album 2.1"));
        artist2.getAlbums().add(new Album(5, "Album 2.2"));
        artist2.getAlbums().add(new Album(6, "Album 2.3"));

        // Tạo Artist 3
        Artist artist3 = new Artist(3, "Artist 3");
        artist3.getAlbums().add(new Album(7, "Album 3.1"));
        artist3.getAlbums().add(new Album(8, "Album 3.2"));
        artist3.getAlbums().add(new Album(9, "Album 3.3"));

        // Thêm các Artist vào danh sách
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
    }

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artists;
    }

    @GetMapping("/artists/{artistId}")
    public Artist getArtistById(@PathVariable int artistId) {
        for (Artist artist : artists) {
            if (artist.getId() == artistId) {
                return artist;
            }
        }
        return null;
    }

    @GetMapping("/albums/{albumId}")
    public Album getAlbumById(@PathVariable int albumId) {
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                if (album.getId() == albumId) {
                    return album;
                }
            }
        }
        return null;
    }

    @GetMapping("/artist/{index}")
    public Artist getArtistByIndex(@PathVariable int index) {
        if (index >= 0 && index < artists.size()) {
            return artists.get(index);
        }
        return null;
    }
}
