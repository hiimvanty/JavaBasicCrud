package com.devcamp.api.music_api_task_56cdot80_90_100.models;

public class Composer extends Person {
    private String stagename;

    public Composer(String firstname, String lastname, String stagename) {
        super(firstname, lastname);
        this.stagename = stagename;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

}
