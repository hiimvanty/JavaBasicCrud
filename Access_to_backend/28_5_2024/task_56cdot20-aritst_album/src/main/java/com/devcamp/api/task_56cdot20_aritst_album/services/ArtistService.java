package com.devcamp.api.task_56cdot20_aritst_album.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devcamp.api.task_56cdot20_aritst_album.models.Album;
import com.devcamp.api.task_56cdot20_aritst_album.models.Artist;

@Service
public class ArtistService {
    private ArrayList<Artist> artists;

    public ArtistService() {
        artists = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        // Tao artist 1
        Artist artist1 = new Artist(1, "Son Tung-Mtp");
        artist1.getAlbums().add(new Album(1, "Album 1.1 "));
        artist1.getAlbums().add(new Album(2, "Album 1.2"));
        artist1.getAlbums().add(new Album(3, "Album 1.3"));

        // Tao artist 2

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

    public ArrayList<Artist> getAllArtists() {
        return artists;
    }

    public Artist getArtistById(int artistId) {
        for (Artist artist : artists) {
            if (artist.getId() == artistId) {
                return artist;
            }
        }
        return null;
    }

    public Artist getArtistByIndex(int index) {
        if (index >= 0 && index < artists.size()) {
            return artists.get(index);
        }
        return null;
    }
}
