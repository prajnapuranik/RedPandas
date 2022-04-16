package com.example.spotifyshuffler.songs;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Document(collection = "spotifylist")
public class Songs {

    /* If we don't specify ID, mongoDB will create a unique _id

    @Id
    private String Id;

     */

    @Id
    private String title;

    private String artist;
    private String genre;
    private int year;
    private int bpm;
    private int nrgy;
    private int dnce;
    private int dB;
    private int pop;

    public Songs(String title, String artist, String genre, int year, int bpm, int nrgy, int dnce, int dB, int pop) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.bpm = bpm;
        this.nrgy = nrgy;
        this.dnce = dnce;
        this.dB = dB;
        this.pop = pop;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getNrgy() {
        return nrgy;
    }

    public void setNrgy(int nrgy) {
        this.nrgy = nrgy;
    }

    public int getDnce() {
        return dnce;
    }

    public void setDnce(int dnce) {
        this.dnce = dnce;
    }

    public int getdB() {
        return dB;
    }

    public void setdB(int dB) {
        this.dB = dB;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }
}
