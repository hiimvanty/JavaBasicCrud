package com.devcamp.api.music_api_task_56cdot80_90_100.models;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private String bandname;
    private List<BandMember> members;
    private List<Albums> albums;

    public Band(String bandname, List<BandMember> members, List<Albums> albums) {
        this.members = new ArrayList<>(members);
        this.albums = new ArrayList<>(albums);
        this.bandname = bandname;
       

    }

    public String getBandname() {
        return bandname;
    }

    public List<BandMember> getMembers() {
        return new ArrayList<>(members);
    }

    public List<Albums> getAlbums() {
        return new ArrayList<>(albums);
    }

    public void addAlbum(Albums album) {
        this.albums.add(album);
    }
}
