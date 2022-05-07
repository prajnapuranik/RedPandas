package com.example.spotifyshuffler.songs;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "viral50")
public class SongsViral50 {

    @Id
    String title;
    String artist;
    String region;
    String chart;
    String trend;

/*
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private java.util.Date date;
*/

    public SongsViral50(String title, String artist, String region, String chart, String trend) {
        this.title = title;
        this.artist = artist;
        this.region = region;
        this.chart = chart;
        this.trend = trend;
        //this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    */
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

}
