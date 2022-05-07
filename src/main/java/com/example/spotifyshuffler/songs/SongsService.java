package com.example.spotifyshuffler.songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Songs> getSongsByRank(String rank){
        List<Songs> songsList = songsRepo.findByRank(rank);
        return songsList;
    }

    public List<Songs> getSongsByRankLessThan(){
        List<Songs> songsList= songsRepo.getSongsByRank();
        return songsList;
    }

    public List<Songs> getSongsByRegion(String region){
        List<Songs> songsList= songsRepo.findByRegion(region);
        return songsList;
    }

    public List<Songs> getSongsByTitle(String title){
        List<Songs> songsList = songsRepo.findByTitle(title);
        return songsList;
    }

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

    /*
    public Songs updateSongArtist(Songs song){
        Songs newSong = songsRepo.findByTitle(song.getTitle());
        newSong.setArtist(song.getArtist());
        return songsRepo.save(song);
    }*/

    //DELETE
    public String deleteSongByTitle(String title){
        songsRepo.deleteByTitle(title);
        return "Deleted Successfully";
    }

}
