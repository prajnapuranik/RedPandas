package com.example.spotifyshuffler.songs;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "top200")
public class Songs {

    @Id
    private ObjectId id;

    private String title;

    int rank;

    private String artist;
    private String region;
    private String chart;
    private Double streams;

    /*
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private java.util.Date date;
     */

    public Songs(String title, int rank, String artist, String region, String chart, Double streams) {
        this.title = title;
        this.rank = rank;
        this.artist = artist;
        this.region = region;
        this.chart = chart;
        this.streams = streams;
        //this.date = date;
    }

    public String getTitle() {
        System.out.println(title);
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public Double getStreams() {
        return streams;
    }

    public void setStreams(Double streams) {
        this.streams = streams;
    }
}
