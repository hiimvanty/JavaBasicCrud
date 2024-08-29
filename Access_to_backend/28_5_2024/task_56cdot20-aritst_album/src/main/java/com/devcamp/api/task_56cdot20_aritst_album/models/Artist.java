package com.devcamp.api.task_56cdot20_aritst_album.models;

import java.util.ArrayList;

public class Artist {
    private int id;
    private String name;
    private ArrayList<Album> albums;

    public Artist() {

    }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public Artist(int id, String name, ArrayList<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

}
