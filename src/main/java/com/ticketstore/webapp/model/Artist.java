package com.ticketstore.webapp.model;

public class Artist {
    private String id;
    private String artist_name;
    private String genre_id;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getArtist_name() {
        return artist_name;
    }
    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
    public String getGenre_id() {
        return genre_id;
    }
    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    
    
}
