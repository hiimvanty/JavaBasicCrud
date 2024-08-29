package com.devcamp.api.music_api_task_56cdot80_90_100.models;

public class BandMember extends Composer {
    private String instrument;

    public BandMember(String firstname, String lastname, String stagename, String instrument) {
        super(firstname, lastname, stagename);
        this.instrument = instrument;
    }

}
