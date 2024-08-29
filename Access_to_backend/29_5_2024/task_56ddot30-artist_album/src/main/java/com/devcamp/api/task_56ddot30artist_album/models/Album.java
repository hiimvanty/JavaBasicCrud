package com.devcamp.api.task_56ddot30artist_album.models;

import java.util.ArrayList;

public class Album {
    private int id;
    private String name;
    private ArrayList<String> songs;

    public Album() {

    }

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public Album(int id, String name, ArrayList<String> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
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

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

}
