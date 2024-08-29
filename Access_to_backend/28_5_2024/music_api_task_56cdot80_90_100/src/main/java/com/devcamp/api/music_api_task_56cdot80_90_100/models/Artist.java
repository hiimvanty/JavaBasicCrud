package com.devcamp.api.music_api_task_56cdot80_90_100.models;

import java.util.List;

public class Artist extends Composer {
    private List<Albums> albums;

    public Artist(String firstname, String lastname, List<Albums> albums, String stagename) {
        super(firstname, lastname, stagename);
        this.albums = albums;
    }

}
