package com.example.spotifyshuffler.songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SongsService {

    @Autowired
    private SongsRepository songsRepo;

    public List<Songs> getAllSongs() {
        List<Songs> songsList = new ArrayList<Songs>();
        songsRepo.findAll().forEach(songsList::add);
        return songsList;
    }

    public List<Songs> getSongsByArtist(String artist){
        List<Songs> songsList = new ArrayList<Songs>();
        for(Songs s: songsRepo.findByArtist(artist)){
            songsList.add(s);
        }
        return songsList;
    }

    //NOT WORKING
    public List<Songs> getSongsByRank(int rank){
        List<Songs> songsList = songsRepo.findByRank(rank);
        return songsList;
    }

    //NOT WORKING
    public List<Songs> getSongsByRankLessThan(){
        List<Songs> songsList= songsRepo.getSongsByRank();
        return songsList;
    }

    public List<Songs> getSongsByRegion(String region){
        List<Songs> songsList= songsRepo.findByRegion(region);
        return songsList;
    }

    public Songs getSongsByTitle(String title){
        return songsRepo.findByTitle(title);
    }

    public Integer getSongsCountByArtist(String artist){
        return songsRepo.getSongsCountByArtist(artist);
    }

    public List<Songs> getSongRankGreaterThan(int rank){
        List<Songs> songsList= songsRepo.findByRankGreaterThan(rank);
        return songsList;
    }

    /*
    public List<Songs> getSongRankLesserThan(int rank){
        List<Songs> songsList= songsRepo.findByRankLesserThan(rank);
        return songsList;
    }

     */

    //NOT WORKING
    public List<Songs> getSongsByStreams(Double streams){
        List<Songs> songsList= new ArrayList<>() ;
        for(Songs s: songsRepo.findByStreams(streams)){
            songsList.add(s);
        }
        return songsList;
    }

    //CREATE
    public Songs saveSongService(Songs song){
        return songsRepo.save(song);
        //return "Added song successfully";
    }

    //Update
    public Songs updateSongArtist(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setArtist(song.getArtist());
        return songsRepo.save(song);
    }

    public Songs updateSongTitle(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setTitle(song.getTitle());
        return songsRepo.save(song);
    }

    public Songs updateSongRegion(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setRegion(song.getRegion());
        return songsRepo.save(song);
    }

    public Songs updateSongChart(Songs song) {
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setChart(song.getChart());
        return songsRepo.save(song);
    }

    //DELETE
    public String deleteSongByTitle(String title){

        try {
            songsRepo.deleteByTitle(title);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return "Deleted Successfully";
    }

    public String deleteSongByArtist(String artist){
        try {
            songsRepo.deleteByArtist(artist);
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return "Deleted Successfully";
    }

    public Long countAllDocuments(){
        return songsRepo.countAllDocuments();
    }

}
